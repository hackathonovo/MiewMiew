//
//  MapViewController.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//
//  This file was generated by the 🐍 VIPER generator
//

import UIKit

final class MapViewController: UIViewController {

     // MARK: - Public properties -

     var presenter: MapPresenterInterface!

     // MARK: - Lifecycle -

     override func viewDidLoad() {
         super.viewDidLoad()
        title = "Map"
     }

}

// MARK: - Extensions -

extension MapViewController: MapViewInterface {
}

extension MapViewController: TabBarItemSetupable {
    
    func setupTabBarItem() {
        tabBarItem.image = UIImage.fontAwesomeIcon(name: .map, textColor: UIColor.blue, size: CGSize(width: 32, height: 32))
        tabBarItem.selectedImage = UIImage.fontAwesomeIcon(name: .map, textColor: UIColor.blue, size: CGSize(width: 32, height: 32))
        tabBarItem.title = "Map"
    }
}
