import {Component, OnInit} from "@angular/core";
import {MdDialog, MdDialogRef} from "@angular/material";
import {RescueActionService} from "../services/rescue-action.service";

declare var google: any;

@Component({
  selector: 'app-pick-location-dialog',
  templateUrl: 'pick-location-dialog.component.html',
  styleUrls: ['./pick-location-dialog.component.scss']
})
export class PickLocationDialogComponent implements OnInit {

  rescueAction = this.rescueActionService.getActiveRescueAction();

  constructor(public rescueActionService: RescueActionService, public dialog: MdDialog, public dialogRef: MdDialogRef<PickLocationDialogComponent>) {

  }

  ngOnInit() {
    const that = this;

    setTimeout(() => that.initMap(), 1000);
  }

  initMap() {

  }

  save() {
    this.dialogRef.close();
  }

  close() {
    this.dialogRef.close();
  }
}
