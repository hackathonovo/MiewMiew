//
//  LoginInterfaces.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit
import MBProgressHUD

enum Transition {
    case root
    case push
    case present(fromViewController: UIViewController)
}

protocol WireframeInterface: class {
    func popFromNavigationController(animated: Bool)
    func dismiss(animated: Bool)
    func showLoading()
    func hideLoading()
    func showAlert(with message: String, with completion: ((UIAlertAction) -> Void)?)
}

class BaseWireframe {

    unowned var navigationController: UINavigationController

    init(navigationController: UINavigationController) {
        self.navigationController = navigationController
    }

    func show(_ viewController: UIViewController, with transition: Transition, animated: Bool) {
        switch transition {
        case .push:
            navigationController.pushViewController(viewController, animated: animated)
        case .present(let fromViewController):
            navigationController.viewControllers = [viewController]
            fromViewController.present(navigationController, animated: animated, completion: nil)
        case .root:
            navigationController.setViewControllers([viewController], animated: animated)
        }
    }
}

extension BaseWireframe: WireframeInterface {

    func popFromNavigationController(animated: Bool) {
        let _ = navigationController.popViewController(animated: animated)
    }

    func dismiss(animated: Bool) {
        navigationController.dismiss(animated: animated)
    }
    
    func showLoading() {
        MBProgressHUD.showAdded(to: navigationController.view, animated: true)
    }
    
    func hideLoading() {
        MBProgressHUD.hide(for: navigationController.view, animated: true)
    }
    
    func showAlert(with message: String, with completion: ((UIAlertAction) -> Void)?) {
        let alertController = UIAlertController(title: message, message: nil, preferredStyle: .alert)
        let okAction = UIAlertAction(title: "OK", style: .default, handler: completion)
        alertController.addAction(okAction)
        navigationController.present(alertController, animated: true, completion: nil)
    }
}
