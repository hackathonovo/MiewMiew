//
//  AppearanceInitializer.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import UIKit
import ChameleonFramework

class AppearanceInitializer: Initializable {
    
    func setup() {
        UIApplication.shared.statusBarStyle = .lightContent
        
        UINavigationBar.appearance().tintColor = UIColor.flatWhite
        UINavigationBar.appearance().barTintColor = UIColor.flatNavyBlue
        UINavigationBar.appearance()
            .titleTextAttributes = [NSForegroundColorAttributeName : UIColor.flatWhite,
                                    NSFontAttributeName: UIFont.font(name: .latoBold, size: 17)]
        
        
        UITabBar.appearance().tintColor = UIColor.flatNavyBlue
        UITabBar.appearance().barTintColor = UIColor.flatWhite
        UITabBarItem.appearance()
            .setTitleTextAttributes([NSFontAttributeName: UIFont.font(name: .latoBold, size: 10)], for: .normal)
    }
}
