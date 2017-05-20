//
//  APIService.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Alamofire
import Unbox

enum Result<T> {
    case success(T)
    case failure(Error)
}

class APIService {
    
    let baseUrl = URL(string: "http://miewmiew.azurewebsites.net/api")!
    
    func login(with username: String, password: String, completion: @escaping (Result<User>) -> Void) {
        Alamofire
            .request(baseUrl.appendingPathComponent("/Users/login") , method: .post, parameters: ["username": username, "password": password], encoding: JSONEncoding.default)
            .responseJSON { (response) in
                switch response.result {
                case .success(let value):
                    if let _value = value as? UnboxableDictionary, let userInfo: User = try? unbox(dictionary: _value) {
                        completion(.success(userInfo))
                    } else if let _value = value as? UnboxableDictionary, let error: APIError = try? unbox(dictionary: _value) {
                        completion(.failure(error))
                    } else {
                        completion(.failure(APIError(message: "Error did occured")))
                    }
                case .failure(let error):
                    completion(.failure(error))
                }
        }
    }
    
    func getActions(completion: @escaping (Result<[RescueAction]>) -> Void) {
        Alamofire
            .request(baseUrl.appendingPathComponent("/RescuerActions/getAll"), method: .get, parameters: nil, encoding: JSONEncoding.default, headers: _headers())
            .responseJSON { (response) in
                switch response.result {
                case .success(let value):
                    print(value)
                    if let _value = value as? [UnboxableDictionary], let actions: [RescueAction] = try? unbox(dictionaries: _value) {
                        completion(.success(actions))
                    } else if let _value = value as? UnboxableDictionary, let error: APIError = try? unbox(dictionary: _value) {
                        completion(.failure(error))
                    } else {
                        completion(.failure(APIError(message: "Error did occured")))
                    }
                case .failure(let error):
                    completion(.failure(error))
                }
        }
    }
    
    func _headers() -> [String: String]{
        if let token = UserDefaults.standard.value(forKey: Constants.UserDefaults.userToken) {
            return ["Authorization": "Bearer \(token)"]
        }
        return [:]
    }
}
