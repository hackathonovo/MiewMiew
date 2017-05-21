import {AfterViewInit, Component} from '@angular/core';
import {RescueAction} from '../classes/rescue-action';
import {FabService} from '../services/fab.service';
import {RescueActionService} from '../services/rescue-action.service';
import {MdDialog} from '@angular/material';
import {RescueActionDialogComponent} from '../rescue-action-dialog/rescue-action-dialog.component';

declare var google: any;

@Component({
  selector: 'app-rescue-action',
  templateUrl: './rescue-action.component.html',
  styleUrls: ['./rescue-action.component.scss']
})
export class RescueActionComponent implements AfterViewInit {
  public rescueActions: Array<RescueAction> = [];

  addButton = null;

  constructor(public fabService: FabService, public rescueActionService: RescueActionService, public dialog: MdDialog) {
  }

  ngAfterViewInit(): void {
    const that = this;
    that.fabService.subscribeToFab(() => that.addRescueAction(), 0);
    this.rescueActionService.getAllRescueActions({
      onSuccess: (data) => {
        that.rescueActions = data;
        setTimeout(() => that.initMapsForAction(), 500);
      }, onError: () => {

      }
    });
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
    const mapElement = document.getElementById('smap-actions-' + rescueAction.id);
    if (!mapElement) {
      return;
    }
    const map = new google.maps.Map(mapElement, {
      zoom: 9,
      center: location
    });
    const marker = new google.maps.Marker({
      position: location,
      map: map
    });

    const circle = new google.maps.Circle({
      strokeColor: '#FF0000',
      strokeOpacity: 0.8,
      strokeWeight: 2,
      fillColor: '#FF0000',
      fillOpacity: 0.35,
      map: map,
      center: location,
      radius: 5000
    });
  }

  addRescueAction() {
    this.rescueActionService.setActiveRescueAction(null);
    this.dialog.open(RescueActionDialogComponent);
    console.log('fab click rescue action');
  }

  openRescueAction(rescueAction) {
    this.rescueActionService.setActiveRescueAction(rescueAction);
    this.rescueActionService.setIsRescueActionOpened(true);
  }

  editRescueAction(rescueAction) {
    this.rescueActionService.setActiveRescueAction(rescueAction);
    this.dialog.open(RescueActionDialogComponent);
  }
}
