//
//  TabBarPresenter.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class TabBarPresenter {
    
    // MARK: - Private properties -
    
    fileprivate weak var _view: TabBarViewInterface?
    fileprivate var _interactor: TabBarInteractorInterface
    fileprivate var _wireframe: TabBarWireframeInterface
    
    // MARK: - Lifecycle -
    
    init(wireframe: TabBarWireframeInterface, view: TabBarViewInterface, interactor: TabBarInteractorInterface) {
        _wireframe = wireframe
        _view = view
        _interactor = interactor
    }
    
}

// MARK: - Extensions -

extension TabBarPresenter: TabBarPresenterInterface {
}
