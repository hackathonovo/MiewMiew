import {Injectable} from "@angular/core";
@Injectable()
export class DistanceService {
  D2R = Math.PI / 180;

  getDistance(lat1, long1, lat2, long2) {
    const D2R = this.D2R;
    const dlong = (long2 - long1) * D2R;
    const dlat = (lat2 - lat1) * D2R;
    const a = Math.pow(Math.sin(dlat / 2.0), 2) + Math.cos(lat1 * D2R) * Math.cos(lat2 * D2R) * Math.pow(Math.sin(dlong / 2.0), 2);
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    const distance = 6367 * c * 1000;
    return distance;
  }

  groupRescues(rescueActions: any[]) {
    const that = this;
    const groupList = [];
    rescueActions.forEach((rescueAction) => {
      rescueAction.addedToGroup = false;
      let counter = 0;
      groupList.forEach((rescueGroup) => {
        rescueGroup.forEach((rescueInGroup) => {
          if (rescueAction.addedToGroup) {
            return;
          }
          const distance = that.getDistance(rescueAction.latitude, rescueAction.longitude, rescueInGroup.latitude, rescueInGroup.longitude);
          if (distance < 100000) {
            rescueAction.addedToGroup = true;
            rescueGroup.push(rescueAction);
          } else {
            console.log("Big distance");
          }
        });
        counter++;
        if (counter === groupList.length && rescueAction.addedToGroup === false) {
          rescueAction.addedToGroup = true;
          groupList.push([rescueAction]);
        }
      });
      if (groupList.length === 0) {
        rescueAction.addedToGroup = true;
        groupList.push([rescueAction]);
      }
    });
    return groupList;
  }

}
