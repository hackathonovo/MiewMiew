//
//  RescueActionPresenter.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class RescueActionPresenter {

    // MARK: - Private properties -

    fileprivate weak var _view: RescueActionViewInterface?
    fileprivate var _interactor: RescueActionInteractorInterface
    fileprivate var _wireframe: RescueActionWireframeInterface
    fileprivate weak var _delegate: RescueActionDelegate?
    fileprivate var _action: RescueAction
    fileprivate var _rescueTypes: [RescueType]

    // MARK: - Lifecycle -

    init(wireframe: RescueActionWireframeInterface, view: RescueActionViewInterface, interactor: RescueActionInteractorInterface, delegate: RescueActionDelegate?) {
        _wireframe = wireframe
        _view = view
        _interactor = interactor
        _delegate = delegate
        _action = RescueAction()
        _rescueTypes = []
        
        _interactor.getRescueTypes { [weak self] (result) in
            guard let _self = self else { return }
            switch result {
            case .success(let rescueTypes):
                _self._rescueTypes = rescueTypes
            case .failure(let error):
                _self._wireframe.showAlert(with: error.localizedDescription, with: nil)
            }
        }
    }

}

// MARK: - Extensions -

extension RescueActionPresenter: RescueActionPresenterInterface {
    
    func didSelectCloseAction() {
        _wireframe.dismiss(animated: true)
    }
    
    func didSelectCreateAction() {
        _wireframe.showLoading()
        _interactor.createAction(with: _action) { [weak self] (result) in
            guard let _self = self else { return }
            _self._wireframe.hideLoading()
            switch result {
            case .success(_):
                _self._delegate?.didCreateAction()
                _self._wireframe.dismiss(animated: true)
            case .failure(let error):
                _self._wireframe.showAlert(with: error.localizedDescription, with: nil)
            }
        }
    }
    
    func updateAction(name: String?) {
        _action.name = name
    }
    
    func updateAction(descriptionText: String?) {
        _action.actionDescription = descriptionText
    }
    
    func updateAction(pursuit: Bool) {
        _action.pursuit = pursuit == true ? 1 : 0
    }
    
    func updateAction(rescueType: Int) {
        _action.rescueTypeId = rescueType + 1
    }
    
    func numberOfPickerItems() -> Int {
        return _rescueTypes.count
    }
    
    func pickerTitleFor(_ row: Int) -> String {
        return _rescueTypes[row].type
    }
}
