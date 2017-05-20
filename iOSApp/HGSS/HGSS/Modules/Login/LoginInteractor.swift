//
//  LoginInteractor.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import Foundation

final class LoginInteractor {
    
    fileprivate let _apiService = APIService()
}

// MARK: - Extensions -

extension LoginInteractor: LoginInteractorInterface {
    
    
    func login(with username: String, password: String, completion: @escaping (Result<UserCredentials>) -> Void) {
        _apiService.login(with: username, password: password, completion: completion)
    }
}
