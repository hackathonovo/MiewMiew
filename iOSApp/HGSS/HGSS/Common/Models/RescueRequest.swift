//
//  Request.swift
//  HGSS
//
//  Created by Nikola Majcen on 21/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Foundation
import Unbox

class RescueRequest: Unboxable {
    
    var prihvatio: Bool?
    var akcijaSpasavanja: RescueAction?
    
    required init(unboxer: Unboxer) throws {
        prihvatio = unboxer.unbox(key: "prihvatio")
        akcijaSpasavanja = unboxer.unbox(key: "akcijaSpasavanja")
    }
}
