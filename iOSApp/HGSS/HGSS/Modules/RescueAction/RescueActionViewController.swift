//
//  RescueActionViewController.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class RescueActionViewController: UIViewController {

     // MARK: - Public properties -

     var presenter: RescueActionPresenterInterface!

     // MARK: - Lifecycle -

     override func viewDidLoad() {
         super.viewDidLoad()
        title = "New rescue action"
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
