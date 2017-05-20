import {Component, OnInit} from "@angular/core";
import {UserSimpleModel} from "../interfaces/user.simple.model";
import {LoginService} from "../services/login.service";
import {MdDialog, MdDialogRef} from "@angular/material";
import {RegisterDialogComponent} from "../register-dialog/register-dialog.component";
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-login-dialog',
  templateUrl: 'login-dialog.component.html',
  styles: []
})
export class LoginDialogComponent implements OnInit {

  public user: UserSimpleModel = {username: '', password: ''};

  constructor(public loginService: LoginService, public dialog: MdDialog, public userService: UserService, public dialogRef: MdDialogRef<LoginDialogComponent>) {

  }

  ngOnInit() {

  }

  login() {
    const that = this;
    this.loginService.login(this.user, {
      onSuccess: (data) => {
        console.log('Successful login');
        that.userService.saveLogin(data);
        that.dialogRef.close();
      }, onError: () => {
      }
    });
  }

  openRegisterDialog() {
    this.dialog.open(RegisterDialogComponent);
  }
}
