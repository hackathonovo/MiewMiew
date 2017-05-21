import {AfterViewInit, Component} from "@angular/core";
import {UserService} from "./services/user.service";
import {LoginDialogComponent} from "./login-dialog/login-dialog.component";
import {MdDialog} from "@angular/material";
import {FabService} from "./services/fab.service";
import {RescueActionService} from "app/services/rescue-action.service";
import {RescueTypeService} from "./services/rescue-type.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements AfterViewInit {
  title: String = 'Team: MiewMiew';
  public tabSelectedIndex: Number = 0;

  constructor(public userService: UserService, public dialog: MdDialog, public fabService: FabService,
              public rescueActionService: RescueActionService, private rescueTypeService: RescueTypeService) {
    this.userService.loadUser();
    const successError = {
      onSuccess: (data) => {
      }, onError: () => {
      }
    };
    this.rescueTypeService.fetchRescueTypes(successError);
    this.rescueTypeService.fetchRescuerAbilities(successError);
    this.rescueTypeService.fetchMapping(successError);
  }

  public selectedIndexChange(event) {
    this.tabSelectedIndex = event.index;
    console.log(this.tabSelectedIndex);
  }

  ngAfterViewInit(): void {
    setTimeout(() => {
      document.getElementById('sidenav-toolbar-rows--hidden').parentElement.style.display = 'none';
    }, 0);
  }

  // tab border below fix
  onSidenavToogle(): void {
    const currentTabIndex = this.tabSelectedIndex;
    this.tabSelectedIndex = 0;
    this.tabSelectedIndex = 1;
    this.tabSelectedIndex = currentTabIndex;
    console.log(currentTabIndex);
  }

  openLoginDialog() {
    this.dialog.open(LoginDialogComponent);
  }

  goToHGSS() {
    window.location.href = 'http://www.gss.hr';
  }

  logoutLabel() {
    if (this.userService.isLoggedIn()) {
      return 'Logout';
    }
    return '';
  }

  loginLabel() {
    if (!this.userService.isLoggedIn()) {
      return 'Login';
    }
    return '';
  }

  onFabClick() {
    this.fabService.call(this.tabSelectedIndex);
  }
}
