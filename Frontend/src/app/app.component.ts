import {AfterViewInit, Component} from "@angular/core";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements AfterViewInit {
  title: String = 'Team: MiewMiew';
  tabSelectedIndex: Number = 0;

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
}
