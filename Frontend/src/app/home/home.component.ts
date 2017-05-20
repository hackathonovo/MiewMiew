import {AfterViewInit, Component} from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements AfterViewInit {

  ngAfterViewInit() {
    const background = document.getElementById('home-background');
    background.style.height = (window.innerHeight - 64 - 48) + 'px';
  }
}
