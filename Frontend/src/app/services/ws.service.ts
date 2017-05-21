import {Injectable} from "@angular/core";

@Injectable()
export class WSService {

  wsPath = 'ws://miewmiew.azurewebsites.net/notifications';
  ws: WebSocket = null;
  isConnecting = false;
  attempts = 0;
  callbacks = [];

  constructor() {
  }

  connect() {
    /*
    let asd = false;
    asd = true;
    if (asd) {
      return;
    }*/
    const that = this;
    if (that.ws && that.ws.close && that.ws.readyState !== 1) {
      that.ws.close();
    }
    this.isConnecting = true;
    that.ws = new WebSocket(this.wsPath);

    that.ws.onopen = function () {
      that.attempts = 0;
      that.isConnecting = false;
      console.log('Succeeded to open a connection');
    };

    that.ws.onerror = function (error) {
      console.log('Failed to open a connection');
      that.isConnecting = false;
      if (that.attempts > 30) {
        console.log('Stopping socket reconnection');
      } else {
        that.attempts++;
        const time = 2000;
        setTimeout(function () {
          that.connect();
        }, time);
      }
    };

    that.ws.onmessage = function (message) {
      const data = !(typeof message.data === 'string') && JSON.parse(message.data) || message.data ;
      that.callbacks.forEach(function (callback) {
        callback(data);
      });
    };
  };

  sendMessage(message) {
    const ws = this.ws;
    if (ws && ws.readyState === 1) {
      // ws.send(JSON.stringify(message));
      ws.send(message);
    } else {
      console.log('Can\'t send message via socket');
      this.attempts = 0;
      this.connect();
    }
  };

  subscribeToSocketMessage(callback) {
    this.callbacks.push(callback);
  }
}
