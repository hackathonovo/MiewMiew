//
//  APIError.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Foundation
import Unbox
import Wrap

class APIError: LocalizedError, Unboxable {
    
    let message: String
    
    public var errorDescription: String? {
        get {
            return "\(message)."
        }
    }
    
    init(message: String) {
        self.message = message
    }
    
    required convenience init (unboxer: Unboxer) throws {
        let message: String = try unboxer.unbox(key: "title")
        self.init(message: message)
    }
}
