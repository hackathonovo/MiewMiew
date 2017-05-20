//
//  RescueActionViewController.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit
import FontAwesome_swift

final class RescueActionViewController: UIViewController {

     // MARK: - Public properties -

     var presenter: RescueActionPresenterInterface!

     // MARK: - Lifecycle -

     override func viewDidLoad() {
         super.viewDidLoad()
        title = "New rescue action"
        _setupNavigationBar()
     }

    fileprivate func _setupNavigationBar() {
        let closeImage = UIImage.fontAwesomeIcon(name: .close, textColor: UIColor.flatWhite, size: CGSize(width: 32, height: 32))
        navigationItem.leftBarButtonItem = UIBarButtonItem(image: closeImage, style: .plain, target: self, action: #selector(didSelectCloseAction))
    }
    
    func didSelectCloseAction() {
        presenter.didSelectCloseAction()
    }
}

// MARK: - Extensions -

extension RescueActionViewController: RescueActionViewInterface {
}


extension RescueActionViewController: TabBarItemSetupable {
    
    func setupTabBarItem() {
        tabBarItem.image = UIImage.fontAwesomeIcon(name: .map, textColor: UIColor.blue, size: CGSize(width: 32, height: 32))
        tabBarItem.selectedImage = UIImage.fontAwesomeIcon(name: .map, textColor: UIColor.blue, size: CGSize(width: 32, height: 32))
        tabBarItem.title = "Rescue"
    }
}
