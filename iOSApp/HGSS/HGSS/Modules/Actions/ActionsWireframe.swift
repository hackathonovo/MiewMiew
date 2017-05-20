//
//  ActionsWireframe.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class ActionsWireframe: BaseWireframe {

    // MARK: - Private properties -

    private let _storyboard: UIStoryboard = UIStoryboard(name: "Actions", bundle: nil)

    // MARK: - Module setup -

    func configureModule(with viewController: ActionsViewController) {
        let interactor = ActionsInteractor()
        let presenter = ActionsPresenter(wireframe: self, view: viewController, interactor: interactor)
        viewController.presenter = presenter
        viewController.setupTabBarItem()
    }

    // MARK: - Transitions -

    func show(with transition: Transition, animated: Bool = true) {
        let moduleViewController = _storyboard.instantiateViewController(withIdentifier: "ActionsViewController") as! ActionsViewController
        configureModule(with: moduleViewController)

        show(moduleViewController, with: transition, animated: animated)
    }

}

// MARK: - Extensions -

extension ActionsWireframe: ActionsWireframeInterface {

    func navigate(to option: ActionsNavigationOption) {
        switch option {
        case .details(let action):
            let wireframe = ActionDetailsWireframe(navigationController: navigationController)
            wireframe.show(with: .push, action: action)
        }
    }

}
