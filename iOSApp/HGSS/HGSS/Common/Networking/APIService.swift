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
    
    let CBaseUrl = URL(string: "http://miewmiew.azurewebsites.net/api")!
    let JBaseUrl = URL(string: "http://d1152294.ngrok.io/api")!
    
    func login(with username: String, password: String, completion: @escaping (Result<UserCredentials>) -> Void) {
        Alamofire
            .request(CBaseUrl.appendingPathComponent("/Users/login") , method: .post, parameters: ["username": username, "password": password], encoding: JSONEncoding.default)
            .responseJSON { (response) in
                switch response.result {
                case .success(let value):
                    if let _value = value as? UnboxableDictionary, let userInfo: UserCredentials = try? unbox(dictionary: _value) {
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
            .request(CBaseUrl.appendingPathComponent("/RescuerActions/getAll"), method: .get, parameters: nil, encoding: JSONEncoding.default, headers: _headers())
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
    
    func getRescueTypes(completion: @escaping (Result<[RescueType]>) -> Void) {
        Alamofire
            .request(JBaseUrl.appendingPathComponent("/vrstespasavanja/getAll"), method: .get, encoding: JSONEncoding.default)
            .responseJSON { (response) in
                switch response.result {
                case .success(let value):
                    print(value)
                    if let _value = value as? [UnboxableDictionary], let actions: [RescueType] = try? unbox(dictionaries: _value) {
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
    
    func createAction(with action: RescueAction, completion: @escaping (Result<RescueAction>) -> Void) {
        guard let actionJSON = action.asJSON() else { return }
        print(actionJSON)
        Alamofire
            .request(CBaseUrl.appendingPathComponent("/RescuerActions/save"), method: .post, parameters: actionJSON, encoding: JSONEncoding.default, headers: _headers())
            .responseJSON { (response) in
                switch response.result {
                case .success(let value):
                    print(value)
                    if let _value = value as? UnboxableDictionary, let action: RescueAction = try? unbox(dictionary: _value) {
                        completion(.success(action))
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
    
    func getRescuers(by actionId: Int, completion: @escaping (Result<[User]>) -> Void) {
        Alamofire
            .request(CBaseUrl.appendingPathComponent("/RescuerActions/getAvailableUsers/\(actionId)"), method: .get, encoding: JSONEncoding.default, headers: _headers())
            .responseJSON { (response) in
                switch response.result {
                case .success(let value):
                    print(value)
                    if let _value = value as? [UnboxableDictionary], let actions: [User] = try? unbox(dictionaries: _value) {
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
    
    func addParticipant(by userId: String, actionId: Int, completion: @escaping (Result<Bool>) -> Void) {
        Alamofire
            .request(JBaseUrl.appendingPathComponent("/sudionici/Add/\(actionId)/\(userId)"), method: .get, encoding: JSONEncoding.default)
            .responseJSON { (response) in
                switch response.result {
                case .success(_):
                    completion(.success(true))
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
