//
//  SocketMessage.swift
//  HGSS
//
//  Created by Nikola Majcen on 21/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Foundation

import Unbox
import Wrap

protocol SocketJSONMessage {
    func asJSONString() -> String?
}

extension SocketJSONMessage {
    
    func asJSONString() -> String? {
        if let _json: WrappedDictionary = try? wrap(self), let _data = try? JSONSerialization.data(withJSONObject: _json, options: .prettyPrinted),
            let _jsonString = String(data: _data, encoding: .utf8) {
            return _jsonString
        }
        return nil
    }
}

class SocketMessage: SocketJSONMessage, Unboxable {
    
    let Message: String
    
    init(message: String) {
        Message = message
    }
    
    required convenience init(unboxer: Unboxer) throws {
        let message: String = try unboxer.unbox(key: "Message")
        self.init(message: message)
    }
}
