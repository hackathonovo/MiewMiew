import {AfterViewInit, Component} from "@angular/core";
import {User} from "../classes/user";
import {MdDialog} from "@angular/material";
import {RescueTypeService} from "../services/rescue-type.service";

@Component({
  selector: 'app-code-books',
  templateUrl: './code-books.component.html',
  styleUrls: ['./code-books.component.scss']
})
export class CodeBooksComponent implements AfterViewInit {
  public rescuers: Array<User> = [];

  selectedRescueType = null;
  selectedRescuerAbility = null;

  newType = null;
  newAbility = null;

  constructor(public dialog: MdDialog, public rescueTypeService: RescueTypeService) {
  }

  ngAfterViewInit(): void {
    const that = this;
  }

  selectRescueType(rescueType) {
    this.selectedRescueType = rescueType;
  }

  selectRescuerAbility(rescuerAbility) {
    this.selectedRescuerAbility = rescuerAbility;
  }

  addMapping() {
    const that = this;
    this.rescueTypeService.mapTypeAbility({
      onSuccess: (data) => {
        console.log(data);
        that.selectedRescueType = null;
        that.selectedRescuerAbility = null;
      }, onError: () => {
      }
    }, that.selectedRescueType.id, that.selectedRescuerAbility.id);
  }

  deleteMapping(typeId, abilityId) {
    this.rescueTypeService.deleteMapping({
      onSuccess: (data) => {
      }, onError: () => {
      }
    }, typeId, abilityId);
  }

  addType() {
    const that = this;
    this.rescueTypeService.addType(this.newType, {
      onSuccess: (data) => {
        console.log(data);
        that.newType = {id: data.id, vrsta: that.newType};
        that.rescueTypeService.getRescueTypes().push(that.newType);
        that.newType = null;
      }, onError: () => {
      }
    });
  }

  addAbility() {
    const that = this;
    this.rescueTypeService.addAbility(this.newAbility, {
      onSuccess: (data) => {
        console.log(data);
        that.newAbility = {id: data.id, naziv: that.newAbility};
        that.rescueTypeService.getRescuerAbilities().push(that.newAbility);
        that.newAbility = null;
      }, onError: () => {
      }
    });
  }
}
