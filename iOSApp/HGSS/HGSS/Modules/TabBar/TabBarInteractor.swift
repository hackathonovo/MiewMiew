//
//  TabBarInteractor.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import Foundation

final class TabBarInteractor {
    
    let _apiService = APIService()
}

// MARK: - Extensions -

extension TabBarInteractor: TabBarInteractorInterface {
    
    func fetchRequests(with userId: String, completion: @escaping (Result<[RescueRequest]>) -> Void) {
        _apiService.fetchRequests(with: userId, completion: completion)
    }
}
