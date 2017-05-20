//
//  TabBarWireframe.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class TabBarWireframe: BaseWireframe {

    // MARK: - Private properties -

    private let _storyboard: UIStoryboard = UIStoryboard(name: "TabBar", bundle: nil)

    fileprivate let actionsNavigationContorller = UINavigationController()
    fileprivate let mapsNavigationContorller = UINavigationController()
    fileprivate let rescueActionNavigationController = UINavigationController()
    fileprivate let profileNavigationController = UINavigationController()
    
    fileprivate lazy var tabBarWireframes: [BaseWireframe] =  {
        let actions = ActionsWireframe(navigationController: self.actionsNavigationContorller)
        let maps = MapWireframe(navigationController: self.mapsNavigationContorller)
        let rescueAction = RescueActionWireframe(navigationController: self.rescueActionNavigationController)
        let profile = ProfileWireframe(navigationController: self.profileNavigationController)
        
        actions.show(with: .root, animated: false)
        maps.show(with: .root, animated: false)
        rescueAction.show(with: .root, animated: false)
        profile.show(with: .root, animated: false)
        
        return [actions, maps, rescueAction, profile]
    }()
    
    // MARK: - Module setup -
    
    func configureModule(with tabBarController: TabBarController) {
        let interactor = TabBarInteractor()
        let presenter = TabBarPresenter(wireframe: self, view: tabBarController, interactor: interactor)
        
        tabBarController.presenter = presenter
        tabBarController.viewControllers = tabBarWireframes.map({ $0.navigationController })
        
        navigationController.setNavigationBarHidden(false, animated: false)
    }
    
    // MARK: - Transitions -
    
    func show(with transition: Transition, animated: Bool = true) {
        let moduleViewController = _storyboard.instantiateViewController(withIdentifier: "TabBarController") as! TabBarController
        configureModule(with: moduleViewController)
        show(moduleViewController, with: transition, animated: animated)
    }
}

// MARK: - Extensions -

extension TabBarWireframe: TabBarWireframeInterface {

    func navigate(to option: TabBarNavigationOption) {
    }

}
