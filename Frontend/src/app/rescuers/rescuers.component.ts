import {AfterViewInit, Component} from "@angular/core";
import {User} from "../classes/user";
import {MdDialog} from "@angular/material";
import {RescuerDialogComponent} from "../rescuer-dialog/rescuer-dialog.component";
import {RescuerService} from "../services/rescuer.service";

@Component({
  selector: 'app-rescuers',
  templateUrl: './rescuers.component.html',
  styleUrls: ['./rescuers.component.scss']
})
export class RescuersComponent implements AfterViewInit {
  public rescuers: Array<User> = [];

  constructor(public dialog: MdDialog, public rescuerService: RescuerService) {
  }

  ngAfterViewInit(): void {
    const that = this;
    this.rescuerService.fetchAllRescuers({
      onSuccess: (data) => {
        that.rescuers = data;
      }, onError: () => {
      }
    });
  }

  editRescuer(rescuer, index) {
    this.rescuerService.setActiveUser(rescuer, index);
    this.dialog.open(RescuerDialogComponent);
  }
}
