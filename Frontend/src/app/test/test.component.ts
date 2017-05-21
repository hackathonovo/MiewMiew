import {Component} from '@angular/core';
import {MdDialog, MdSnackBar} from '@angular/material';
import {DialogComponent} from '../dialog/dialog.component';
import {WSService} from '../services/ws.service';
import {Headers, Http, RequestOptions, Response} from '@angular/http';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {LoginService} from '../services/login.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss'],
  providers: [WSService, LoginService]
})
export class TestComponent {
  bufferValue = 0;
  socketMessage = '';
  socketMessageReceived = '';

  constructor(public dialog: MdDialog, public snackBar: MdSnackBar, public wsService: WSService, public http: Http, private loginService: LoginService) {
    this.incrementBufferValue();
    wsService.connect();
    wsService.subscribeToSocketMessage((message) => this.onSocketMessage(message));
  }

  incrementBufferValue() {
    this.bufferValue += 0.2;
    setTimeout(() => {
      if (this.bufferValue > 100) {
        this.bufferValue = 0;
        setTimeout(() => {
          this.incrementBufferValue();
        }, 1000);
      } else {
        this.incrementBufferValue();
      }
    }, 10);
  }

  openDialog() {
    this.dialog.open(DialogComponent);
  }

  openSnackBar() {
    this.snackBar.open('Congratulations, now you can open snack bar', 'close', {
      duration: 2000,
    });
  }

  sendSocketMessage() {
    const message = {
      seronja: 'Ivan',
      level: '9000'
    };
    this.wsService.sendMessage(this.socketMessage);
  }

  onSocketMessage(message: any) {
    console.log(message);
    this.socketMessageReceived = message;
  }

  callApi() {
    const that = this;
    const headers = new Headers({'Content-Type': 'application/json'});
    const options = new RequestOptions({headers: headers});
    this.loginService.login({username: 'nekej1', password: 'hoho123341'}, {
      onSuccess: (data) => {
        that.snackBar.open('Congratulations, now you can open snack bar', 'close', {
          duration: 2000,
        });
      }, onError: () => {
      }
    });
  }
}
