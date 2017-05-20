import { Injectable } from '@angular/core';
import { GenericService} from './generic.service';
import { UserSimpleModel } from '../interfaces/user.simple.model';
import { SuccessError } from '../interfaces/success.error';
import { LoginResponse } from '../interfaces/login.response';
import { TokenRegisterModel } from '../interfaces/token.register.model';

@Injectable()
export class LoginService {

  constructor(private genericService: GenericService) { }

  login(userLoginModel: UserSimpleModel, successError: SuccessError) {
    this.genericService.getObservablePost<LoginResponse>('api/Users/login/', userLoginModel)
      .subscribe(successError.onSuccess, successError.onError);
  }
}
