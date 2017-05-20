//
//  ProfileInterfaces.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

enum ProfileNavigationOption {
    case login
}

protocol ProfileWireframeInterface: WireframeInterface {
    func navigate(to option: ProfileNavigationOption)
}

protocol ProfileViewInterface: ViewInterface {
}

protocol ProfilePresenterInterface: PresenterInterface {
    func didSelectLogoutAction()
}

protocol ProfileInteractorInterface: InteractorInterface {
}
