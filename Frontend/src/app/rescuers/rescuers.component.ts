import {AfterViewInit, Component} from '@angular/core';
import {RescueAction} from '../classes/rescue-action';
import {User} from '../classes/user';

@Component({
  selector: 'app-rescuers',
  templateUrl: './rescuers.component.html',
  styleUrls: ['./rescuers.component.scss']
})
export class RescuersComponent implements AfterViewInit {
  public rescuers: Array<User> = [{
    id: '1',
    username: 'pero',
    email: 'pero@example.com',
    ime: 'Pero',
    prezime: 'Perić',
    phonenumber: '-',
    razina: 4,
    latitude: 46.269888,
    longitude: 16.3482354,
    adresa: 'Zagreb',
    photo: ''
  }, {
    id: '2',
    username: 'ivo',
    email: 'ivo@example.com',
    ime: 'Ivo',
    prezime: 'Ivić',
    phonenumber: '-',
    razina: 4,
    latitude: 46.269888,
    longitude: 16.3482354,
    adresa: 'Zadar',
    photo: ''
  }, {
    id: '3',
    username: 'ivo',
    email: 'ivo@example.com',
    ime: 'Ivo',
    prezime: 'Ivić',
    phonenumber: '-',
    razina: 4,
    latitude: 46.269888,
    longitude: 16.3482354,
    adresa: 'Zadar',
    photo: ''
  }, {
    id: '4',
    username: 'ivo',
    email: 'ivo@example.com',
    ime: 'Ivo',
    prezime: 'Ivić',
    phonenumber: '-',
    razina: 4,
    latitude: 46.269888,
    longitude: 16.3482354,
    adresa: 'Zadar',
    photo: ''
  }, {
    id: '5',
    username: 'ivo',
    email: 'ivo@example.com',
    ime: 'Ivo',
    prezime: 'Ivić',
    phonenumber: '-',
    razina: 4,
    latitude: 46.269888,
    longitude: 16.3482354,
    adresa: 'Zadar',
    photo: ''
  }];

  constructor() {
  }

  ngAfterViewInit(): void {
  }
}
