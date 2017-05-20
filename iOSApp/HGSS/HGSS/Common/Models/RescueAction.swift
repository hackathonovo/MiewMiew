//
//  RescueAction.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Foundation
import Unbox

enum RescueType: String, UnboxableEnum {
    case speleolog = "Speleolog"
    case alpinist = "Alpinist"
    case voda = "Voda"
    case helikopter = "Helikopter"
}

enum RescueCycleType: String, UnboxableEnum {
    case created = "Created"
    case pendind = "Pending"
    case inProgress = "InProgress"
    case finishedSuccessfully = "FinishedSuccessfully"
    case finishedFailed = "FinishedFailed"
}

class RescueAction: Unboxable {
    
    let id: Int
    let name: String
    let actionDescription: String
    let dateTime: Date
    let pursuit: Int
    
//    let latitude: Double
//    let longitude: Double
    
    var rescueType: RescueType?
    var rescueLifecycle: RescueCycleType?
    
    required init(unboxer: Unboxer) throws {
        id = try unboxer.unbox(key: "id")
        name = try unboxer.unbox(key: "naziv")
        actionDescription = try unboxer.unbox(key: "opis")
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "YYYY-MM-dd'T'HH:mm:ss.SSS"
        dateTime = try unboxer.unbox(key: "vrijeme", formatter: dateFormatter)
        pursuit = try unboxer.unbox(key: "potraga")
//        latitude = try unboxer.unbox(key: "latitude")
//        longitude = try unboxer.unbox(key: "longiture")
        rescueType = unboxer.unbox(key: "rescueType")
        rescueLifecycle = unboxer.unbox(key: "rescueLiveCycle")
    }

}
