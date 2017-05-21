import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule, JsonpModule } from '@angular/http';
import {
  StyleModule,
  MdButtonModule,
  MdButtonToggleModule,
  MdCheckboxModule,
  MdIconModule,
  MdCoreModule,
  MdToolbarModule,
  MdSidenavModule,
  MdChipsModule,
  MdProgressSpinnerModule,
  MdProgressBarModule,
  MdMenuModule,
  MdDialogModule,
  MdTooltipModule,
  MdSnackBarModule,
  MdInputModule,
  MdTabsModule,
  MdCardModule, MdRadioModule, MdSelectModule
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {Router, RouterModule, Routes} from '@angular/router';

import 'hammerjs';

import {AppComponent} from './app.component';
import {DialogComponent} from './dialog/dialog.component';

import {HomeComponent} from './home/home.component';
import {TestComponent} from './test/test.component';
import {RescueActionComponent} from './rescue-action/rescue-action.component';
import {GenericService} from 'app/services/generic.service';
import {UserService} from './services/user.service';
import {LoginService} from './services/login.service';
import {RegisterService} from './services/register.service';
import {SessionService} from './services/session.service';
import {CookieService} from 'angular2-cookie/core';
import {MapsComponent} from './maps/maps.component';
import {LoginDialogComponent} from './login-dialog/login-dialog.component';
import {RegisterDialogComponent} from './register-dialog/register-dialog.component';
import {RescuersComponent} from './rescuers/rescuers.component';
import {RescuerService} from './services/rescuer.service';
import {RescuerDialogComponent} from './rescuer-dialog/rescuer-dialog.component';
import {FabService} from './services/fab.service';
import {RescueActionDialogComponent} from './rescue-action-dialog/rescue-action-dialog.component';
import {RescueActionService} from "app/services/rescue-action.service";
import {PickLocationDialogComponent} from "./pick-location-dialog/pick-location-dialog.component";
import {OpenedRescueActionComponent} from "./opened-rescue-action/opened-rescue-action.component";
import {RescueTypeService} from "./services/rescue-type.service";
import {DistanceService} from "./services/distance.service";
import {CodeBooksComponent} from "./code-books/code-books.component";

const apiKey = 'AIzaSyCaNJfY49tznGZ9V_rofRFt0bIB8uNqFEY';

const appRoutes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'test', component: TestComponent},
  { path: '', component: HomeComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    DialogComponent,
    HomeComponent,
    TestComponent,
    RescueActionComponent,
    MapsComponent,
    LoginDialogComponent,
    RegisterDialogComponent,
    RescuersComponent,
    RescuerDialogComponent,
    RescueActionDialogComponent,
    PickLocationDialogComponent,
    OpenedRescueActionComponent,
    CodeBooksComponent
  ],
  entryComponents: [
    DialogComponent, LoginDialogComponent, RegisterDialogComponent, RescuerDialogComponent, RescueActionDialogComponent, PickLocationDialogComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    StyleModule,
    MdButtonModule,
    MdButtonToggleModule,
    MdCheckboxModule,
    MdIconModule,
    MdCoreModule,
    MdToolbarModule,
    MdSidenavModule,
    MdChipsModule,
    MdProgressSpinnerModule,
    MdProgressBarModule,
    MdMenuModule,
    MdDialogModule,
    MdTooltipModule,
    MdSnackBarModule,
    MdInputModule,
    MdTabsModule,
    MdCardModule,
    MdRadioModule,
    MdSelectModule,
    BrowserAnimationsModule,
    // RouterModule.forRoot(appRoutes),
  ],
  providers: [GenericService, UserService, LoginService, RegisterService, SessionService, CookieService, RescuerService, FabService, RescueActionService, RescueTypeService, DistanceService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
