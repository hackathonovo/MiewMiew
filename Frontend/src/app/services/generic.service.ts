import {Injectable} from "@angular/core";
import {Headers, Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import {UserService} from "./user.service";
import {SessionService} from "./session.service";

@Injectable()
export class GenericService {

  private static API_BASE_URL(dotNet: Boolean): string {
    if (dotNet) {
      return 'http://miewmiew.azurewebsites.net/';
    } else {
      return 'http://d1152294.ngrok.io/';
    }
  }

  constructor(private userService: UserService,
              private http: Http,
              private sessionService: SessionService) {
    this.sessionService.initialize(this);
  }

  getHeaders(): Headers {
    const headers: Headers = new Headers();
    headers.append('Content-Type', 'application/json');
    if (this.userService.isLoggedIn()) {
      headers.append('Authorization', 'Bearer ' + this.userService.token);
    }
    return headers;
  }

  getObservableGet<T>(path: string, dotNet: Boolean = true): Observable<T> {
    return this.http.get(
      GenericService.API_BASE_URL(dotNet) + path,
      {headers: this.getHeaders()})
      .map((response: Response) => <T>response.json());
  }

  getObservablePost<R>(path: string, object: any, dotNet: Boolean = true): Observable<R> {
    return this.http.post(
      GenericService.API_BASE_URL(dotNet) + path,
      JSON.stringify(object),
      {headers: this.getHeaders()})
      .map((res: Response) => <R>res.json());
  }

  checkSession(checkingSession: boolean) {
    if (checkingSession)
      this.sessionService.checkSession(this);
  }
}
