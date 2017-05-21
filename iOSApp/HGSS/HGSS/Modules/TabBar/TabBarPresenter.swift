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
    
    var timer: Timer!
    
    // MARK: - Lifecycle -
    
    init(wireframe: TabBarWireframeInterface, view: TabBarViewInterface, interactor: TabBarInteractorInterface) {
        _wireframe = wireframe
        _view = view
        _interactor = interactor
    }
    
    deinit {
        timer.invalidate()
    }
    
    @objc func _fetchData() {
        _fetchRequests()
    }
    
    func _fetchRequests() {
        guard let _userId = UserDefaults.standard.value(forKey: Constants.UserDefaults.userId) as? String else { return }
        _interactor.fetchRequests(with: _userId) { [weak self] (result) in
            switch result {
            case .success(let requests):
                if requests.isEmpty == false {
                    self?._view?.setNotificitionsCount(to: requests.count)
                }
            case .failure(_):
                break
            }
        }
    }
}

// MARK: - Extensions -

extension TabBarPresenter: TabBarPresenterInterface {
    
    func viewDidLoad() {
        timer = Timer.scheduledTimer(timeInterval: 15, target: self, selector: #selector(_fetchData), userInfo: nil, repeats: true)
    }
}
