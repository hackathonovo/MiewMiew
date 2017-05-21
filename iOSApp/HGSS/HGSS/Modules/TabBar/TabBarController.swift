//
//  TabBarViewController.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class TabBarController: UITabBarController {
    
    // MARK: - Public properties -
    
    var presenter: TabBarPresenterInterface!
    
    // MARK: - Lifecycle -
    
    override func viewDidLoad() {
        super.viewDidLoad()
        _setupTabBar()
        presenter.viewDidLoad()
    }
    
    fileprivate func _setupTabBar() {
        tabBar.isTranslucent = false
    }
}

// MARK: - Extensions -

extension TabBarController: TabBarViewInterface {
    
    func setNotificitionsCount(to value: Int) {
        if let item = tabBar.items?[2] {
            item.badgeValue = String(value)
        }
    }
}


extension TabBarController: UITabBarControllerDelegate {
    
    override func tabBar(_ tabBar: UITabBar, didSelect item: UITabBarItem) {
        item.badgeValue = nil
    }
}
