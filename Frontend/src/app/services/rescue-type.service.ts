import {Injectable} from "@angular/core";
import {GenericService} from "./generic.service";
import {RescueType} from "../classes/rescue-type";
import {RescuerAbility} from "../classes/rescuer-ability";
import {TypeAbilityMap} from "../classes/type-ability-map";

@Injectable()
export class RescueTypeService {

  public rescueTypes: Array<RescueType> = [];
  public rescuerAbilities: Array<RescuerAbility> = [];

  public rescueTypesNamed = {};
  public rescuerAbilitiesNamed = {};

  public typeAbilityMapping: Array<TypeAbilityMap> = [];


  constructor(private genericService: GenericService) {

  }

  getRescueTypes() {
    return this.rescueTypes;
  }

  getRescuerAbilities() {
    return this.rescuerAbilities;
  }

  getRescueTypesNamed() {
    return this.rescueTypesNamed;
  }

  getRescuerAbilitiesNamed() {
    return this.rescuerAbilitiesNamed;
  }

  getTypeAbilityMapping() {
    return this.typeAbilityMapping;
  }

  fetchRescueTypes(successError) {
    const that = this;
    this.genericService.getObservableGet<Array<RescueType>>('api/vrstespasavanja/getAll', false)
      .subscribe((data) => {
        console.log(data);
        that.rescueTypes = data;
        that.rescueTypes.forEach((rescueType) => {
          that.rescueTypesNamed[rescueType.id + ''] = rescueType.vrsta;
        });
        successError.onSuccess(data);
      }, successError.onError);
  }

  fetchRescuerAbilities(successError) {
    const that = this;
    this.genericService.getObservableGet<Array<RescuerAbility>>('/api/specijalnosti/getAll', false)
      .subscribe((data) => {
        console.log(data);
        that.rescuerAbilities = data;
        that.rescuerAbilities.forEach((rescuerAbility) => {
          that.rescuerAbilitiesNamed[rescuerAbility.id + ''] = rescuerAbility.naziv;
        });
        successError.onSuccess(data);
      }, successError.onError);
  }

  fetchMapping(successError) {
    const that = this;
    this.genericService.getObservableGet<Array<TypeAbilityMap>>('/api/specijalnostiVrstaSpasavanja/getAll', false)
      .subscribe((data) => {
        console.log(data);
        that.typeAbilityMapping = data;
        successError.onSuccess(data);
      }, successError.onError);
  }


  // /api/specijalnostiVrstaSpasavanja/Add/{vrstaSpasavanjaId}/{specijalnostId}
  mapTypeAbility(successError, typeId, abilityId) {
    const that = this;
    let found = false;
    that.typeAbilityMapping.forEach((typeAbilityMap) => {
      if (typeAbilityMap.vrstaId === typeId && typeAbilityMap.specijalnostId === abilityId) {
        found = true;
      }
    });
    if (!found) {
      that.typeAbilityMapping.push({vrstaId: typeId, specijalnostId: abilityId});
      this.genericService.getObservableGet<Array<GenericService>>('/api/specijalnostiVrstaSpasavanja/Add/' + typeId + '/' + abilityId, false)
        .subscribe((data) => {
          successError.onSuccess(data);
        }, successError.onError);
    }
  }

  deleteMapping(successError, typeId, abilityId) {
    const that = this;
    let typeAbilityMapSearch = null;
    that.typeAbilityMapping.forEach((typeAbilityMap) => {
      if (typeAbilityMap.vrstaId === typeId && typeAbilityMap.specijalnostId === abilityId) {
        typeAbilityMapSearch = typeAbilityMap;
      }
    });
    if (typeAbilityMapSearch) {
      const index = this.typeAbilityMapping.indexOf(typeAbilityMapSearch);
      this.typeAbilityMapping.splice(index, 1);
      this.genericService.getObservableGet<Array<GenericService>>('/api/specijalnostiVrstaSpasavanja/Delete/' + typeId + '/' + abilityId, false)
        .subscribe((data) => {
          successError.onSuccess(data);
        }, successError.onError);
    }
  }

  addType(value, successError) {
    this.genericService.getObservablePost<Array<GenericService>>('/api/vrstespasavanja/Add', {id: 0, vrsta: value}, false)
      .subscribe((data) => {
        successError.onSuccess(data);
      }, successError.onError);
  }

  addAbility(value, successError) {
    this.genericService.getObservablePost<Array<GenericService>>('/api/specijalnosti/save', {id: 0, naziv: value}, false)
      .subscribe((data) => {
        successError.onSuccess(data);
      }, successError.onError);
  }
}
