//
//  RescueType.swift
//  HGSS
//
//  Created by Nikola Majcen on 21/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Foundation
import Unbox

class RescueType: Unboxable {
    
    var id: Int
    var type: String
    
    required init(unboxer: Unboxer) throws {
        id = try unboxer.unbox(key: "id")
        type = try unboxer.unbox(key: "vrsta")
    }
}
