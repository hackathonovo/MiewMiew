import {AfterViewInit, Component} from "@angular/core";
import {RescueActionService} from "../services/rescue-action.service";
import {DistanceService} from "../services/distance.service";

declare const google: any;
declare const subscribeToGoogleMapInit: any;

@Component({
  selector: 'app-maps',
  templateUrl: './maps.component.html',
  styleUrls: ['./maps.component.scss']
})
export class MapsComponent implements AfterViewInit {
  lat = 45.1062882;
  lng = 15.584347;
  initializedMap = false;

  constructor(private rescueActionService: RescueActionService, private distanceService: DistanceService) {

  }

  initMap() {
    const centerLocation = {lat: this.lat, lng: this.lng};
    const mapElement = document.getElementById('map');
    if (!mapElement || this.initializedMap) {
      return;
    }
    this.initializedMap = true;
    const map = new google.maps.Map(document.getElementById('map'), {
      zoom: 7,
      center: centerLocation
    });
    this.adjustBackground();
    const rescueActions = this.rescueActionService.getRescueActions();
    rescueActions.forEach((rescueAction) => {
      const locationRescue = {lat: rescueAction.latitude, lng: rescueAction.longitude};
      const marker = new google.maps.Marker({
        position: locationRescue,
        map: map
      });
    });
    console.log(rescueActions);
    const groupList = this.distanceService.groupRescues(rescueActions);
    console.log(groupList);
    groupList.forEach((groupInList) => {
      const location = {lat: groupInList[0].latitude, lng: groupInList[0].longitude};
      const circle = new google.maps.Circle({
        strokeColor: '#FF0000',
        strokeOpacity: 0.8,
        strokeWeight: 2,
        fillColor: '#FF0000',
        fillOpacity: 0.35,
        map: map,
        center: location,
        radius: groupInList.length * 10000
      });
    });
  }

  initMapTimeout() {
    const that = this;
    setTimeout(() => that.initMap(), 100);
    return ' ';
  }

  ngAfterViewInit() {
    const that = this;
    subscribeToGoogleMapInit(() => {
      setTimeout(() => that.initMap(), 2000);
    });
  }

  adjustBackground() {
    const that = this;
    const background = document.getElementById('map');
    if (background) {
      background.style.height = (window.innerHeight - 64 - 48) + 'px';
    } else {
      setTimeout(() => that.adjustBackground(), 100);
    }
  }
}
