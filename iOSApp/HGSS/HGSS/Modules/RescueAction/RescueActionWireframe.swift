//
//  RescueActionWireframe.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class RescueActionWireframe: BaseWireframe {

    // MARK: - Private properties -

    private let _storyboard: UIStoryboard = UIStoryboard(name: "RescueAction", bundle: nil)

    // MARK: - Module setup -

    func configureModule(with viewController: RescueActionViewController, delegate: RescueActionDelegate?) {
        let interactor = RescueActionInteractor()
        let presenter = RescueActionPresenter(wireframe: self, view: viewController, interactor: interactor, delegate: delegate)
        viewController.presenter = presenter
        viewController.setupTabBarItem()
    }

    // MARK: - Transitions -

    func show(with transition: Transition, animated: Bool = true, delegate: RescueActionDelegate?) {
        let moduleViewController = _storyboard.instantiateViewController(withIdentifier: "RescueActionViewController") as! RescueActionViewController
        configureModule(with: moduleViewController, delegate: delegate)

        show(moduleViewController, with: transition, animated: animated)
    }

}

// MARK: - Extensions -

extension RescueActionWireframe: RescueActionWireframeInterface {

    func navigate(to option: RescueActionNavigationOption) {
    }

}
