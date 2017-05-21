//
//  ActionsInteractor.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//
//  This file was generated by the 🐍 VIPER generator
//

import Foundation

final class ActionsInteractor {
    
    let _apiService = APIService()
}

// MARK: - Extensions -

extension ActionsInteractor: ActionsInteractorInterface {
    
    func getActions(completion: @escaping (Result<[RescueAction]>) -> Void) {
        _apiService.getActions(completion: completion)
    }
}
