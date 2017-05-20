//
//  LoginViewController.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit

final class LoginViewController: UIViewController {

    // MARK: _ IBOutlets
    
    @IBOutlet weak var usernameField: UITextField!
    @IBOutlet weak var passwordField: UITextField!
    @IBOutlet weak var errorLabel: UILabel!
    
    // MARK: - Public properties -

    var presenter: LoginPresenterInterface!

    // MARK: - Lifecycle -

    override func viewDidLoad() {
        super.viewDidLoad()
        usernameField.delegate = self
        passwordField.delegate = self
    }
    
    // MARK: - Actions
    
    @IBAction func didSelectLoginAction(_ sender: UIButton) {
        view.endEditing(true)
        presenter.didSelectLoginAction(with: usernameField.text, password: passwordField.text)
    }
    
    // MARK: - Private methods
    
    fileprivate func _showErroMessage(_ show: Bool, message: String = "") {
        errorLabel.isHidden = !show
        errorLabel.text = message
    }
}

// MARK: - Extensions -

extension LoginViewController: LoginViewInterface {
    
    func showLoginError(with message: String) {
        _showErroMessage(true, message: message)
    }
}

extension LoginViewController: UITextFieldDelegate {
    
    func textFieldDidBeginEditing(_ textField: UITextField) {
        _showErroMessage(false)
    }
    
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        _showErroMessage(false)
        return true
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        if textField == usernameField {
            passwordField.becomeFirstResponder()
        } else if textField == passwordField {
            passwordField.resignFirstResponder()
        }
        return true
    }
}
