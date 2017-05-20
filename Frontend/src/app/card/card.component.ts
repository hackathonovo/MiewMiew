import {Component} from '@angular/core';
import {MdDialog, MdSnackBar} from '@angular/material';

@Component({
  selector: 'app-cards',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent {

  constructor(public dialog: MdDialog, public snackBar: MdSnackBar) {
  }

}
