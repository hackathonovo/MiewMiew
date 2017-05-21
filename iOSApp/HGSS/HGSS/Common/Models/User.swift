//
//  User.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Foundation
import Unbox

class User: Unboxable {
    
    var id: String?
    let username: String
    var firstName: String?
    var lastName: String?
    var latitude: Double?
    var longitude: Double?
    var distance: Int?
    
    required init(unboxer: Unboxer) throws {
        id = try unboxer.unbox(key: "id")
        username = try unboxer.unbox(key: "userName")
        firstName = unboxer.unbox(key: "ime")
        lastName = unboxer.unbox(key: "prezime")
        latitude = unboxer.unbox(key: "latitude")
        longitude = unboxer.unbox(key: "longitude")
        distance = unboxer.unbox(key: "udaljenost")
    }
}
