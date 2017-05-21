import {Injectable} from "@angular/core";
import {GenericService} from "./generic.service";
import {RescueType} from "../classes/rescue-type";

@Injectable()
export class RescueTypeService {

  public rescueTypes: Array<RescueType> = [];

  constructor(private genericService: GenericService) {

  }

  getRescueTypes() {
    return this.rescueTypes;
  }

  fetchRescueTypes(successError) {
    const that = this;
    this.genericService.getObservableGet<Array<RescueType>>('api/vrstespasavanja/getAll', false)
      .subscribe((data) => {
        console.log(data);
        that.rescueTypes = data;
        successError.onSuccess(data);
      }, successError.onError);
  }

  // /api/vrstespasavanja/getAll
}
