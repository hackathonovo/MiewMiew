import {Injectable} from "@angular/core";
import {RescueAction} from "../classes/rescue-action";
import {GenericService} from "./generic.service";
import {GenericResponse} from "../interfaces/generic.response";
import {User} from "app/classes/user";

@Injectable()
export class RescueActionService {

  public Speleologist = 'Speleologist';
  public Alpinist = 'Alpinist';
  public Water = 'Water';
  public Helicopter = 'Helicopter';

  activeRescueAction: RescueAction = null;
  private isRescueActionOpened = false;

  public rescueActions;

  constructor(public genericService: GenericService) {

  }

  getActiveRescueAction() {
    return this.activeRescueAction;
  }

  setActiveRescueAction(rescueAction) {
    this.activeRescueAction = rescueAction;
  }

  getIsRescueActionOpened(): boolean {
    return this.isRescueActionOpened;
  }

  setIsRescueActionOpened(isRescueActionOpened: boolean) {
    this.isRescueActionOpened = isRescueActionOpened;
  }

  getRescueActions() {
    return this.rescueActions;
  }

  getAllRescueActions(successError) {
    const that = this;
    this.genericService.getObservableGet<RescueAction>('/api/RescuerActions/getAll')
      .subscribe((data) => {
        that.rescueActions = data;
        console.log(data);
        successError.onSuccess(data);
      }, successError.onError);
  }

  addNewRescueAction(rescueAction, successError) {
    this.genericService.getObservablePost<GenericResponse>('/api/RescuerActions/save', rescueAction)
      .subscribe(successError.onSuccess, successError.onError);
  }

  editRescueAction(rescueAction, successError) {
    this.genericService.getObservablePost<GenericResponse>('/api/RescuerActions/save', rescueAction)
      .subscribe(successError.onSuccess, successError.onError);
  }

  getActiveUsersRescue(actionId, successError) {
    this.genericService.getObservableGet<User>('/api/RescuerActions/getAvailableUsers/' + actionId)
      .subscribe(successError.onSuccess, successError.onError);
  }

  respondToRequest(userId, actionId, successError) {
    this.genericService.getObservableGet<User>('/api/RescuerActions/acceptMyRequest/' + userId + '/' + actionId)
      .subscribe(successError.onSuccess, successError.onError);
  }
}
