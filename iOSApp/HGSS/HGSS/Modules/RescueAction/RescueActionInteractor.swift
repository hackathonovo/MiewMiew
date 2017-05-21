//
//  RescueActionInteractor.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import Foundation

final class RescueActionInteractor {
    
    let _apiService = APIService()
}

// MARK: - Extensions -

extension RescueActionInteractor: RescueActionInteractorInterface {
    
    func getRescueTypes(completion: @escaping (Result<[RescueType]>) -> Void) {
        _apiService.getRescueTypes(completion: completion)
    }
    
    func createAction(with action: RescueAction, completion: @escaping (Result<RescueAction>) -> Void) {
        _apiService.createAction(with: action, completion: completion)
    }
}
