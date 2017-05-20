//
//  LoginInterfaces.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

enum LoginNavigationOption {
    case home
}

protocol LoginWireframeInterface: WireframeInterface {
    func navigate(to option: LoginNavigationOption)
}

protocol LoginViewInterface: ViewInterface {
    func showLoginError(with message: String)
}

protocol LoginPresenterInterface: PresenterInterface {
    func didSelectLoginAction(with username: String?, password: String?)
}

protocol LoginInteractorInterface: InteractorInterface {
    func login(with username: String, password: String, completion: @escaping (Result<UserCredentials>) -> Void)
}
