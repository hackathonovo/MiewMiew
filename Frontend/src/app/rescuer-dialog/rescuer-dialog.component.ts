import {Component, OnInit} from "@angular/core";
import {LoginService} from "../services/login.service";
import {MdDialog, MdDialogRef} from "@angular/material";
import {RegisterDialogComponent} from "../register-dialog/register-dialog.component";
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-rescuer-dialog',
  templateUrl: 'rescuer-dialog.component.html',
  styles: ['./rescuer-dialog.component.scss']
})
export class RescuerDialogComponent implements OnInit {


  constructor(public loginService: LoginService, public dialog: MdDialog, public userService: UserService, public dialogRef: MdDialogRef<RescuerDialogComponent>) {

  }

  ngOnInit() {

  }

  // that.dialogRef.close();

  openRegisterDialog() {
    this.dialog.open(RegisterDialogComponent);
  }
}
