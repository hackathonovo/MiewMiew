import {Injectable} from "@angular/core";
import {User} from "../classes/user";
import {GenericService} from "./generic.service";

@Injectable()
export class RescuerService {

  user: User = null;
  index = 1;

  rescuers;

  constructor(private genericService: GenericService) {
  }

  setActiveUser(user, index = 1) {
    this.user = user;
    this.index = index;
  }

  getActiveUser() {
    return this.user;
  }

  getIndex() {
    return this.index;
  }

  getRescuers() {
    return this.rescuers;
  }

  fetchAllRescuers(successError) {
    const that = this;
    this.genericService.getObservableGet<User>('/api/user/getAll', false)
      .subscribe((data) => {
        that.rescuers = data;
        console.log(data);
        successError.onSuccess(data);
      }, successError.onError);
  }
}
