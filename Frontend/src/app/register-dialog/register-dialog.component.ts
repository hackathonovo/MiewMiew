import {Component, OnInit} from "@angular/core";
import {UserSimpleModel} from "../interfaces/user.simple.model";
import {LoginService} from "../services/login.service";
import {RegisterService} from "../services/register.service";
import {MdDialog} from "@angular/material";

@Component({
  selector: 'app-register-dialog',
  templateUrl: 'register-dialog.component.html',
  styles: []
})
export class RegisterDialogComponent implements OnInit {

  public user: UserSimpleModel = {username: '', password: '', email: ''};

  constructor(public registerService: RegisterService) {

  }

  ngOnInit() {

  }

  register() {
    this.registerService.register(this.user, {
      onSuccess: (data) => {
        console.log('Successful register');
      }, onError: () => {
      }
    });
  }
}
