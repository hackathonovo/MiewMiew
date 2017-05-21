//
//  SocketManager.swift
//  HGSS
//
//  Created by Nikola Majcen on 21/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Starscream
import CoreLocation
import Unbox

protocol SocketClient: class {
    func didConnect()
    func didDisconnect()
}

protocol SocketMessageClient: SocketClient {
    func didReceive(message: String)
}

protocol SocketObserver {
    func subscribe(subscriber: SocketClient)
    func unsubscribe(subscriber: SocketClient)
    func isConnected() -> Bool
    func connect()
    func disconnect()
    func send(message: String)
}

class SocketManager {
    
    static let shared = SocketManager()
    
    fileprivate var _socket: WebSocket
    fileprivate var _subscribers: [SocketClient] = []
    
    private init() {
        _socket = WebSocket(url: URL(string: "ws://miewmiew.azurewebsites.net/notifications")!)
        _socket.delegate = self
        _socket.connect()
    }
    
    deinit {
        _socket.disconnect(forceTimeout: 300.0, closeCode: 1000)
    }
}

extension SocketManager: SocketObserver {
    
    func subscribe(subscriber: SocketClient) {
        if _subscribers.filter({ $0 === subscriber }).isEmpty {
            _subscribers.append(subscriber)
        }
    }
    
    func unsubscribe(subscriber: SocketClient) {
        _subscribers = _subscribers.filter({ $0 !== subscriber })
    }
    
    func connect() {
        if !_socket.isConnected {
            _socket.connect()
        }
    }
    
    func disconnect() {
        if _socket.isConnected {
            _socket.disconnect(forceTimeout: 300.0, closeCode: 1000)
        }
    }
    
    func isConnected() -> Bool {
        return _socket.isConnected
    }
    
    func send(message: String) {
        let _message = SocketMessage(message: message)
        if let _jsonString = _message.asJSONString() {
            _socket.write(string: _jsonString)
        }
    }
}

extension SocketManager: WebSocketDelegate {
    
    func websocketDidConnect(socket: WebSocket) {
        print(socket.headers)
        print("Connected")
        _subscribers.forEach({ $0.didConnect() })
    }
    
    func websocketDidDisconnect(socket: WebSocket, error: NSError?) {
        print(socket.headers)
        print("Disconnected")
        _subscribers.forEach({ $0.didDisconnect() })
    }
    
    func websocketDidReceiveMessage(socket: WebSocket, text: String) {
        print("Received:")
        print(text)
        guard let data = text.data(using: .utf8) else { return }
        
        if let _message: SocketMessage = try? unbox(data: data) {
            _subscribers
                .flatMap({ $0 as? SocketMessageClient })
                .forEach({ $0.didReceive(message: _message.Message) })
        }    }
    
    func websocketDidReceiveData(socket: WebSocket, data: Data) {
        // Nothing to do...
    }
}
