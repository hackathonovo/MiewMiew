//
//  RescueActionInterfaces.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

protocol RescueActionDelegate: class {
    func didCreateAction()
}

enum RescueActionNavigationOption {
}

protocol RescueActionWireframeInterface: WireframeInterface {
    func navigate(to option: RescueActionNavigationOption)
}

protocol RescueActionViewInterface: ViewInterface {
}

protocol RescueActionPresenterInterface: PresenterInterface {
    func didSelectCloseAction()
}

protocol RescueActionInteractorInterface: InteractorInterface {
}
