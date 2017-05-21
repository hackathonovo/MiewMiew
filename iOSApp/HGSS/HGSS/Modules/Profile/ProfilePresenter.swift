//
//  ProfilePresenter.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class ProfilePresenter {

    // MARK: - Private properties -

    fileprivate weak var _view: ProfileViewInterface?
    fileprivate var _interactor: ProfileInteractorInterface
    fileprivate var _wireframe: ProfileWireframeInterface

    // MARK: - Lifecycle -

    init(wireframe: ProfileWireframeInterface, view: ProfileViewInterface, interactor: ProfileInteractorInterface) {
        _wireframe = wireframe
        _view = view
        _interactor = interactor
    }
    
    // MARK: - Private methods
    
    fileprivate func _logoutUser() {
        UserDefaults.standard.removeObject(forKey: Constants.UserDefaults.userToken)
        UserDefaults.standard.removeObject(forKey: Constants.UserDefaults.userId)
        UserDefaults.standard.removeObject(forKey: Constants.UserDefaults.username)

    }
}

// MARK: - Extensions -

extension ProfilePresenter: ProfilePresenterInterface {
    
    func didSelectLogoutAction() {
        _logoutUser()
        _wireframe.navigate(to: .login)
    }
}
