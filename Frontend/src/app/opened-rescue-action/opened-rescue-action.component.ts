import {AfterViewInit, Component} from '@angular/core';
import {RescueAction} from '../classes/rescue-action';
import {FabService} from '../services/fab.service';
import {RescueActionService} from "../services/rescue-action.service";
import {MdDialog} from "@angular/material";
import {RescueActionDialogComponent} from "../rescue-action-dialog/rescue-action-dialog.component";

declare var google: any;

@Component({
  selector: 'app-opened-rescue-action',
  templateUrl: './opened-rescue-action.component.html',
  styleUrls: ['./opened-rescue-action.component.scss']
})
export class OpenedRescueActionComponent implements AfterViewInit {

  constructor(public fabService: FabService, public rescueActionService: RescueActionService, public dialog: MdDialog) {
  }

  ngAfterViewInit(): void {
    const that = this;
  }
}
