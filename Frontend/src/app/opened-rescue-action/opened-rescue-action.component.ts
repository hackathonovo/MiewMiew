import {AfterViewInit, Component} from "@angular/core";
import {FabService} from "../services/fab.service";
import {RescueActionService} from "../services/rescue-action.service";
import {MdDialog} from "@angular/material";

declare var google: any;

@Component({
  selector: 'app-opened-rescue-action',
  templateUrl: './opened-rescue-action.component.html',
  styleUrls: ['./opened-rescue-action.component.scss']
})
export class OpenedRescueActionComponent implements AfterViewInit {

  rescueAction = this.rescueActionService.getActiveRescueAction();
  rescuers = [];

  public Math = Math;

  constructor(public fabService: FabService, public rescueActionService: RescueActionService, public dialog: MdDialog) {
  }

  ngAfterViewInit(): void {
    const that = this;

    that.rescueActionService.getActiveUsersRescue(that.rescueAction.id, {
      onSuccess: (data) => {
        that.rescuers = data;
      }, onError: () => {
      }
    });
  }
}
