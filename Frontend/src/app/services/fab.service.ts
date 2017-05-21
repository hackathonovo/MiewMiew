import {Injectable} from "@angular/core";

@Injectable()
export class FabService {

  callbacks = {};

  constructor() {
  }

  subscribeToFab(callback, index) {
    this.callbacks[index] = callback;
  }

  call(index) {
    if (this.callbacks[index]) {
      this.callbacks[index]();
    }
  }
}
