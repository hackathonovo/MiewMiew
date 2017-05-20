//
//  TabBarInterfaces.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

enum TabBarNavigationOption {
    case login
}

protocol TabBarWireframeInterface: WireframeInterface {
    func navigate(to option: TabBarNavigationOption)
}

protocol TabBarViewInterface: ViewInterface {
}

protocol TabBarPresenterInterface: PresenterInterface {
}

protocol TabBarInteractorInterface: InteractorInterface {
}
