//
//  Credentials.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Foundation
import Unbox
import Wrap

class Credentials: Unboxable {
    
    let username: String
    let password: String
    
    init(username: String, password: String) {
        self.username = username
        self.password = password
    }
    
    required convenience init(unboxer: Unboxer) throws {
        let username: String = try unboxer.unbox(key: "username")
        let password: String = try unboxer.unbox(key: "password")
        self.init(username: username, password: password)
    }
}
