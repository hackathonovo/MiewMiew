//
//  LoginPresenter.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class LoginPresenter {

    // MARK: - Private properties -

    fileprivate weak var _view: LoginViewInterface?
    fileprivate var _interactor: LoginInteractorInterface
    fileprivate var _wireframe: LoginWireframeInterface

    // MARK: - Lifecycle -

    init(wireframe: LoginWireframeInterface, view: LoginViewInterface, interactor: LoginInteractorInterface) {
        _wireframe = wireframe
        _view = view
        _interactor = interactor
    }

}

// MARK: - Extensions -

extension LoginPresenter: LoginPresenterInterface {
}
