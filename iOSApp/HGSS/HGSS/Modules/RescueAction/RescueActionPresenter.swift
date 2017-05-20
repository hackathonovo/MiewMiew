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

    // MARK: - Lifecycle -

    init(wireframe: RescueActionWireframeInterface, view: RescueActionViewInterface, interactor: RescueActionInteractorInterface, delegate: RescueActionDelegate?) {
        _wireframe = wireframe
        _view = view
        _interactor = interactor
        _delegate = delegate
    }

}

// MARK: - Extensions -

extension RescueActionPresenter: RescueActionPresenterInterface {
    
    func didSelectCloseAction() {
        _wireframe.dismiss(animated: true)
    }
}
