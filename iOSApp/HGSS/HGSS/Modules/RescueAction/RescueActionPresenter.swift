//
//  RescueActionPresenter.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class RescueActionPresenter {

    // MARK: - Private properties -

    fileprivate weak var _view: RescueActionViewInterface?
    fileprivate var _interactor: RescueActionInteractorInterface
    fileprivate var _wireframe: RescueActionWireframeInterface

    // MARK: - Lifecycle -

    init(wireframe: RescueActionWireframeInterface, view: RescueActionViewInterface, interactor: RescueActionInteractorInterface) {
        _wireframe = wireframe
        _view = view
        _interactor = interactor
    }

}

// MARK: - Extensions -

extension RescueActionPresenter: RescueActionPresenterInterface {
}
