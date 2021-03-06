//
//  ActionsViewController.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//
//  This file was generated by the 🐍 VIPER generator
//

import UIKit

final class ActionsViewController: UIViewController {
    
    @IBOutlet weak var actionsTableView: UITableView!
    
    // MARK: - Public properties -
    
    var presenter: ActionsPresenterInterface!
    
    // MARK: - Lifecycle -
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.viewDidLoad()
        title = "Actions"
        actionsTableView.delegate = self
        actionsTableView.dataSource = self
        actionsTableView.contentInset = UIEdgeInsets(top: 8, left: 0, bottom: 8, right: 0)
        
        actionsTableView.estimatedRowHeight = 101
        actionsTableView.rowHeight = UITableViewAutomaticDimension
        
        _setupNavigationBar()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        presenter.viewWillAppear(animated: animated)
    }
    
    fileprivate func _setupNavigationBar() {
        let addImage = UIImage.fontAwesomeIcon(name: .plus, textColor: UIColor.white, size: CGSize(width: 32, height: 32))
        navigationItem.rightBarButtonItem = UIBarButtonItem(image: addImage, style: .plain, target: self, action: #selector(didSelectAddAction))
    }
    
    func didSelectAddAction() {
        presenter.didSelectAddAction()
    }
}

// MARK: - Extensions -

extension ActionsViewController: ActionsViewInterface {
    
    func reloadView() {
        actionsTableView.reloadData()
    }
}

extension ActionsViewController: TabBarItemSetupable {
    
    func setupTabBarItem() {
        tabBarItem.image = UIImage.fontAwesomeIcon(name: .map, textColor: UIColor.blue, size: CGSize(width: 32, height: 32))
        tabBarItem.selectedImage = UIImage.fontAwesomeIcon(name: .map, textColor: UIColor.blue, size: CGSize(width: 32, height: 32))
        tabBarItem.title = "Actions"
    }
}

extension ActionsViewController: UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return presenter.numberOfActionItems()
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ActionsTableViewCell", for: indexPath) as! ActionsTableViewCell
        cell.configureCell(with: presenter.action(for: indexPath))
        return cell
    }
}

extension ActionsViewController: UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
        presenter.didSelectRescueAction(at: indexPath)
    }
}
