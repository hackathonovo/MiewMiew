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
    case speleologist = "Speleologist"
    case alpinist = "Alpinist"
    case water = "Water"
    case helicopter = "Helicopter"
}

enum RescueCycleType: String, UnboxableEnum {
    case created = "Created"
    case pendind = "Pending"
    case inProgress = "InProgress"
    case finishedSuccessfully = "FinishedSuccessfully"
    case finishedFailed = "FinishedFailed"
}

class RescueAction: Unboxable {
    
    var id: Int?
    var name: String?
    var actionDescription: String?
    var dateTime: Date?
    var pursuit: Int?
    
    var latitude: Double?
    var longitude: Double?
    
    var rescueType: String?
    var rescueLifecycle: RescueCycleType?
    
    var user: User?
    
    init() { }
    
    required convenience init(unboxer: Unboxer) throws {
        let id: Int = try unboxer.unbox(key: "id")
        let name: String = try unboxer.unbox(key: "naziv")
        let actionDescription: String = try unboxer.unbox(key: "opis")
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "YYYY-MM-dd'T'HH:mm:ss.SSS"
        let dateTime: Date? = unboxer.unbox(key: "vrijeme", formatter: dateFormatter)
        let pursuit: Int = try unboxer.unbox(key: "potraga")
        let latitude: Double? = unboxer.unbox(key: "latitude")
        let longitude: Double? = unboxer.unbox(key: "longiture")
        let rescueType: String? = unboxer.unbox(key: "rescueType")
        let rescueLifecycle: RescueCycleType? = unboxer.unbox(key: "rescueLiveCycle")
        let user: User? = unboxer.unbox(key: "user")
        self.init(id: id, name: name, actionDescription: actionDescription, dateTime: dateTime, pursuit: pursuit, latitude: latitude, longitude: longitude, rescueType: rescueType, rescueLifecycle: rescueLifecycle, user: user)
    }
    
    convenience init(id: Int, name: String, actionDescription: String, dateTime: Date?, pursuit: Int, latitude: Double?, longitude: Double?, rescueType: String?, rescueLifecycle: RescueCycleType?, user: User?) {
        self.init()
        self.id = id
        self.name = name
        self.actionDescription = actionDescription
        self.dateTime = dateTime
        self.latitude = latitude
        self.longitude = longitude
        self.rescueType = rescueType
        self.rescueLifecycle = rescueLifecycle
        self.user = user
        self.pursuit = pursuit
    }
}
