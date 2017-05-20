import {AfterViewInit, Component} from "@angular/core";
import {UserService} from "./services/user.service";
import {LoginDialogComponent} from "./login-dialog/login-dialog.component";
import {MdDialog} from "@angular/material";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements AfterViewInit {
  title: String = 'Team: MiewMiew';
  tabSelectedIndex: Number = 0;

  constructor(public userService: UserService, public dialog: MdDialog) {
    this.userService.loadUser();

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
}
