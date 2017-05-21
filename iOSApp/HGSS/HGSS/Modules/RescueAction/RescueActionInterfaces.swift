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
    func didSelectCreateAction()
    func didSelectCloseAction()
    func updateAction(name: String?)
    func updateAction(descriptionText: String?)
    func updateAction(pursuit: Bool)
    func updateAction(rescueType: Int)
    func numberOfPickerItems() -> Int
    func pickerTitleFor(_ row: Int) -> String
}

protocol RescueActionInteractorInterface: InteractorInterface {
    func getRescueTypes(completion: @escaping (Result<[RescueType]>) -> Void)
    func createAction(with action: RescueAction, completion: @escaping (Result<RescueAction>) -> Void)
}
