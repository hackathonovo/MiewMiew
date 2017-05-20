//
//  User.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Foundation
import Unbox

class UserCredentials: Unboxable {
    
    let token: String
    let id: String
    let username: String
    
    required init(unboxer: Unboxer) throws {
        token = try unboxer.unbox(key: "token")
        id = try unboxer.unbox(keyPath: "userInfo.id")
        username = try unboxer.unbox(keyPath: "userInfo.username")
    }
}
