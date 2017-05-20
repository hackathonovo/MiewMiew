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
    
    // MARK: - Private methods
    
    fileprivate func _saveUserData(userInfo: User) {
        UserDefaults.standard.set(userInfo.id, forKey: Constants.UserDefaults.userId)
        UserDefaults.standard.set(userInfo.token, forKey: Constants.UserDefaults.userToken)
        UserDefaults.standard.set(userInfo.username, forKey: Constants.UserDefaults.username)
    }
}

// MARK: - Extensions -

extension LoginPresenter: LoginPresenterInterface {
    
    func didSelectLoginAction(with username: String?, password: String?) {
        guard let _username = username, let _password = password, !_username.isEmpty, !_password.isEmpty else {
            _view?.showLoginError(with: "Username / password not provided.")
            return
        }
        
        _wireframe.showLoading()
        _interactor.login(with: _username, password: _password) { [weak self] result in
            guard let _self = self else { return }
            _self._wireframe.hideLoading()
            switch result {
            case .success(let userInfo):
                _self._saveUserData(userInfo: userInfo)
                _self._wireframe.navigate(to: .home)
            case .failure(let error):
                _self._view?.showLoginError(with: error.localizedDescription)
            }
        }
    }
}
