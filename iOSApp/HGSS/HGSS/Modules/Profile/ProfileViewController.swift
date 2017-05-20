//
//  ProfileViewController.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit
import FontAwesome_swift

final class ProfileViewController: UIViewController {
    
    // MARK: - IBOutlets
    
    @IBOutlet weak var profileImageView: UIImageView!
    @IBOutlet weak var profileTableView: UITableView!
    
    // MARK: - Public properties -
    
    var presenter: ProfilePresenterInterface!
    
    // MARK: - Lifecycle -
    
    override func viewDidLoad() {
        super.viewDidLoad()
        _setupView()
        _setupTable()
    }
    
    // MARK: - Private methods
    
    fileprivate func _setupView() {
        title = "Profile"
    }
    
    fileprivate func _setupTable() {
        profileTableView.delegate = self
        profileTableView.dataSource = self
    }
}

// MARK: - Extensions -

extension ProfileViewController: ProfileViewInterface {
}

extension ProfileViewController: TabBarItemSetupable {
    
    func setupTabBarItem() {
        func setupTabBarItem() {
            tabBarItem.image = UIImage.fontAwesomeIcon(name: .user, textColor: UIColor.blue, size: CGSize(width: 32, height: 32))
            tabBarItem.title = "Profile"
        }
    }
}

extension ProfileViewController: UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        if indexPath.row == 0 {
            presenter.didSelectLogoutAction()
        }
    }
}

extension ProfileViewController: UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ProfileTableViewCell", for: indexPath)
        cell.textLabel?.text = "Logout"
        return cell
    }
}
