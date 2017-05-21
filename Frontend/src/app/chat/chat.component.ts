import {AfterViewInit, Component} from "@angular/core";
import {User} from "../classes/user";
import {MdDialog} from "@angular/material";
import {RescuerService} from "../services/rescuer.service";
import {WSService} from "../services/ws.service";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent implements AfterViewInit {
  public rescuers: Array<User> = [];
  public messages = [];

  public text = "";

  constructor(public dialog: MdDialog, public rescuerService: RescuerService, public wsService: WSService) {
  }

  ngAfterViewInit(): void {
    const that = this;
    this.wsService.subscribeToSocketMessage((message) => {
      that.messages.push(message);
    });
  }
}
