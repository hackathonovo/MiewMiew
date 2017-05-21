import {Component, OnInit} from "@angular/core";
import {MdDialog, MdDialogRef} from "@angular/material";
import {RegisterDialogComponent} from "../register-dialog/register-dialog.component";
import {RescuerService} from "app/services/rescuer.service";
import {User} from "../classes/user";

@Component({
  selector: 'app-rescuer-dialog',
  templateUrl: 'rescuer-dialog.component.html',
  styleUrls: ['./rescuer-dialog.component.scss']
})
export class RescuerDialogComponent implements OnInit {

  user: User = this.rescuerService.getActiveUser();
  index: number = this.rescuerService.getIndex();

  constructor(public rescuerService: RescuerService, public dialog: MdDialog, public dialogRef: MdDialogRef<RescuerDialogComponent>) {
  }

  ngOnInit() {

  }


  edit() {
    this.dialogRef.close();
  }

  close() {
    this.dialogRef.close();
  }
}
