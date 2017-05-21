//
//  APIModel.swift
//  HGSS
//
//  Created by Nikola Majcen on 21/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Foundation
import Wrap

protocol APIModel {
    
    func asJSON() -> [String: Any]?
}

extension APIModel {
    
    func asJSON() -> [String: Any]? {
        if let dictionary: [String: Any] = try? wrap(self) {
            return dictionary
        }
        return nil
    }
}
