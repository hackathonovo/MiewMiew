import {AfterViewInit, Component} from "@angular/core";
import {RescueAction} from "../classes/rescue-action";

declare var google: any;

@Component({
  selector: 'app-rescue-action',
  templateUrl: './rescue-action.component.html',
  styleUrls: ['./rescue-action.component.scss']
})
export class RescueActionComponent implements AfterViewInit {
  public rescueActions: Array<RescueAction> = [{
    id: 1,
    naziv: 'Save from cave',
    nazivLokacije: 'Velebit',
    opis: 'People with children are trapped in the cave. Immediate help needed',
    latitude: 44.5281298,
    longitude: 15.2061534
  }, {
    id: 2,
    naziv: 'Drowning people',
    nazivLokacije: 'Bundek',
    opis: 'Two young boys tried swimming in lake',
    latitude: 45.7878414,
    longitude: 15.9691779
  }];

  constructor() {
  }

  ngAfterViewInit(): void {
    const that = this;
    setTimeout(() => that.initMapsForAction(), 500);
  }

  initMapsForAction() {
    const that = this;
    let counter = 1;
    that.rescueActions.forEach((rescueAction) => {
      setTimeout(() => that.initMap(rescueAction), counter * 200);
      counter += 1;
    });
  }

  initMap(rescueAction) {
    const location = {lat: rescueAction.latitude, lng: rescueAction.longitude};
    const mapElement = document.getElementById('map-actions-' + rescueAction.id);
    const map = new google.maps.Map(mapElement, {
      zoom: 9,
      center: location
    });
    const marker = new google.maps.Marker({
      position: location,
      map: map
    });
  }
}
