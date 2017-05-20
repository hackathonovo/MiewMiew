//
//  LoginViewController.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class LoginViewController: UIViewController {

     // MARK: - Public properties -

     var presenter: LoginPresenterInterface!

     // MARK: - Lifecycle -

     override func viewDidLoad() {
         super.viewDidLoad()
     }

}

// MARK: - Extensions -

extension LoginViewController: LoginViewInterface {
}
