import {AfterViewInit, Component} from "@angular/core";
import {MdDialog} from "@angular/material";
import {LoginDialogComponent} from "../login-dialog/login-dialog.component";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements AfterViewInit {

  constructor(public dialog: MdDialog) {
  }

  adjustBackground() {
    const that = this;
    const background = document.getElementById('home-background');
    if (background) {
      background.style.height = (window.innerHeight - 64 - 48) + 'px';
    } else {
      setTimeout(() => that.adjustBackground(), 100);
    }
  }

  ngAfterViewInit() {
    const that = this;
    setTimeout(() => {
      that.adjustBackground();
    }, 100);
  }

  openLoginDialog() {
    this.dialog.open(LoginDialogComponent);
  }
}
