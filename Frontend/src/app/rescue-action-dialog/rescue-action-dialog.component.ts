import {Component, OnInit} from "@angular/core";
import {MdDialog, MdDialogRef} from "@angular/material";
import {RescueAction} from "../classes/rescue-action";
import {RescueActionService} from "../services/rescue-action.service";
import {UserService} from "app/services/user.service";
import {PickLocationDialogComponent} from "../pick-location-dialog/pick-location-dialog.component";
import {RescueTypeService} from "../services/rescue-type.service";

@Component({
  selector: 'app-rescue-action-dialog',
  templateUrl: 'rescue-action-dialog.component.html',
  styleUrls: ['./rescue-action-dialog.component.scss']
})
export class RescueActionDialogComponent implements OnInit {

  editing = this.rescueActionService.getActiveRescueAction() != null;
  public rescueAction: RescueAction = this.rescueActionService.getActiveRescueAction() || new RescueAction();

  public rescueTypeSelected: String;


  constructor(public rescueActionService: RescueActionService, public userService: UserService, public dialog: MdDialog, public dialogRef: MdDialogRef<RescueActionDialogComponent>,
              public rescueTypeService: RescueTypeService) {
    // this.rescueAction = this.rescueActionService.getActiveRescueAction();
    this.rescueAction.rescueType = this.editing ? this.rescueAction.rescueType : rescueTypeService.getRescueTypes()[0].id;
  }

  ngOnInit() {
  }

  pickLocation() {
    this.rescueActionService.setActiveRescueAction(this.rescueAction);
    this.dialog.open(PickLocationDialogComponent);
  }

  save() {
    const that = this;
    console.log(this.rescueAction);
    this.rescueActionService.addNewRescueAction(this.rescueAction, {
      onSuccess: (data) => {
        console.log(data);
        that.dialogRef.close();
      }, onError: (error) => {
        console.log(error);
      }
    });
  }

  edit() {
    const that = this;
    console.log(this.rescueAction);
    this.rescueActionService.editRescueAction(this.rescueAction, {
      onSuccess: (data) => {
        console.log(data);
        that.dialogRef.close();
      }, onError: (error) => {
        console.log(error);
      }
    });
  }

  close() {
    this.dialogRef.close();
  }
}
