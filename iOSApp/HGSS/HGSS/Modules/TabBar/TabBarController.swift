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
    }
    
    fileprivate func _setupTabBar() {
        tabBar.isTranslucent = false
    }
}

// MARK: - Extensions -

extension TabBarController: TabBarViewInterface {
}
