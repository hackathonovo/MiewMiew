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

    // MARK: - Lifecycle -

    init(wireframe: RescueActionWireframeInterface, view: RescueActionViewInterface, interactor: RescueActionInteractorInterface, delegate: RescueActionDelegate?) {
        _wireframe = wireframe
        _view = view
        _interactor = interactor
        _delegate = delegate
        _action = RescueAction()
    }

}

// MARK: - Extensions -

extension RescueActionPresenter: RescueActionPresenterInterface {
    
    func didSelectCloseAction() {
        _wireframe.dismiss(animated: true)
    }
    
    func didSelectCreateAction() {
        // TODO: POZIV ZA SPREMANJE!!! + dismiss
        _delegate?.didCreateAction()
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
    }
    
    func numberOfPickerItems() -> Int {
        return 3
    }
    
    func pickerTitleFor(_ row: Int) -> String {
        return "Proba"
    }
}
