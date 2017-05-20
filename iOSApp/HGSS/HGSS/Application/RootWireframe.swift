//
//  RootWireframe.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import UIKit

class RootWireframe {
    
    let navigationController = UINavigationController()
    
    func setupApplication() -> UIWindow {
        let window = UIWindow(frame: UIScreen.main.bounds)
        
        LoginWireframe(navigationController: navigationController).show(with: .root, animated: false)
        
        
        //        if let _ = UserDefaults.standard.value(forKey: "userToken") as? String {
        //            TabBarWireframe(navigationController: navigationController).show(with: .root, animated: false)
        //        } else {
        //            LoginWireframe(navigationController: navigationController).show(with: .root, animated: false)
        //        }
        
        navigationController.setNavigationBarHidden(true, animated: false)
        
        window.rootViewController = navigationController
        window.makeKeyAndVisible()
        return window
    }
} 
