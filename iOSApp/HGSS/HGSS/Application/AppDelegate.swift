//
//  AppDelegate.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?

    fileprivate let rootWireframe = RootWireframe()
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
//        setup(initializers: IQKeyboardManagerInitializer(), GoogleMapsInitializer(), AppearanceInitializer())
        window = rootWireframe.setupApplication()
        return true
    }
}

