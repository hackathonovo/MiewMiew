//
//  LoginWireframe.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class LoginWireframe: BaseWireframe {

    // MARK: - Private properties -

    private let _storyboard: UIStoryboard = UIStoryboard(name: "Login", bundle: nil)

    // MARK: - Module setup -

    func configureModule(with viewController: LoginViewController) {
        let interactor = LoginInteractor()
        let presenter = LoginPresenter(wireframe: self, view: viewController, interactor: interactor)
        viewController.presenter = presenter
        navigationController.setNavigationBarHidden(true, animated: false)
    }

    // MARK: - Transitions -

    func show(with transition: Transition, animated: Bool = true) {
        let moduleViewController = _storyboard.instantiateViewController(withIdentifier: "LoginViewController") as! LoginViewController
        configureModule(with: moduleViewController)

        show(moduleViewController, with: transition, animated: animated)
    }

}

// MARK: - Extensions -

extension LoginWireframe: LoginWireframeInterface {

    func navigate(to option: LoginNavigationOption) {
        switch option {
        case .home:
            let wireframe = TabBarWireframe(navigationController: navigationController)
            wireframe.show(with: .root, animated: true)
        }
    }
}
