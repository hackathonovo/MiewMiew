//
//  RescueAction.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Foundation
import Unbox
import Wrap

enum RescueCycleType: String, UnboxableEnum {
    case created = "Created"
    case pendind = "Pending"
    case inProgress = "InProgress"
    case finishedSuccessfully = "FinishedSuccessfully"
    case finishedFailed = "FinishedFailed"
}

class RescueAction: Unboxable, APIModel, WrapCustomizable {
    
    var id: Int?
    var name: String?
    var actionDescription: String?
    var dateTime: Date?
    var pursuit: Int?
    
    var latitude: Double?
    var longitude: Double?
    
    var rescueType: String?
    var rescueTypeId: Int?
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
        let longitude: Double? = unboxer.unbox(key: "longitude")
        let rescueType: String? = unboxer.unbox(key: "rescueType")
        let rescueTypeId: Int? = unboxer.unbox(key: "vrstaSpasavanjaId")
        let rescueLifecycle: RescueCycleType? = unboxer.unbox(key: "rescueLiveCycle")
        let user: User? = unboxer.unbox(key: "user")
        self.init(id: id, name: name, actionDescription: actionDescription, dateTime: dateTime, pursuit: pursuit, latitude: latitude, longitude: longitude, rescueType: rescueType, rescueTypeId: rescueTypeId, rescueLifecycle: rescueLifecycle, user: user)
    }
    
    convenience init(id: Int, name: String, actionDescription: String, dateTime: Date?, pursuit: Int, latitude: Double?, longitude: Double?, rescueType: String?, rescueTypeId: Int?, rescueLifecycle: RescueCycleType?, user: User?) {
        self.init()
        self.id = id
        self.name = name
        self.actionDescription = actionDescription
        self.dateTime = dateTime
        self.latitude = latitude
        self.longitude = longitude
        self.rescueType = rescueType
        self.rescueTypeId = rescueTypeId
        self.rescueLifecycle = rescueLifecycle
        self.user = user
        self.pursuit = pursuit
    }
    
    func keyForWrapping(propertyNamed propertyName: String) -> String? {
        if propertyName == "name" {
            return "naziv"
        } else if propertyName == "actionDescription" {
            return "opis"
        } else if propertyName == "rescueTypeId" {
            return "vrstaSpasavanjaId"
        } else if propertyName == "pursuit" {
            return "potraga"
        } else if propertyName == "dateTime" {
            return "vrijeme"
        }
        return propertyName
    }
}
