//
//  ProfileWireframe.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class ProfileWireframe: BaseWireframe {

    // MARK: - Private properties -

    private let _storyboard: UIStoryboard = UIStoryboard(name: "Profile", bundle: nil)

    // MARK: - Module setup -

    func configureModule(with viewController: ProfileViewController) {
        let interactor = ProfileInteractor()
        let presenter = ProfilePresenter(wireframe: self, view: viewController, interactor: interactor)
        viewController.presenter = presenter
        viewController.setupTabBarItem()
    }

    // MARK: - Transitions -

    func show(with transition: Transition, animated: Bool = true) {
        let moduleViewController = _storyboard.instantiateViewController(withIdentifier: "ProfileViewController") as! ProfileViewController
        configureModule(with: moduleViewController)
        show(moduleViewController, with: transition, animated: animated)
    }

}

// MARK: - Extensions -

extension ProfileWireframe: ProfileWireframeInterface {

    func navigate(to option: ProfileNavigationOption) {
        switch option {
        case .login:
            let wireframe = LoginWireframe(navigationController: navigationController)
            wireframe.show(with: .root, animated: true)
        }
    }
}
