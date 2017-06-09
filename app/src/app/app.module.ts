import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { OrderForm } from '../pages/orderform/orderform';
import { OrderSummary } from '../pages/ordersummary/ordersummary';
import { PartnerProfile } from '../pages/partnerprofile/partnerprofile';
import { PartnerSignUp } from '../pages/partnersignup/partnersignup';
import { VolunteerProfile } from '../pages/volunteerprofile/volunteerprofile';
import { VolunteerSignUp } from '../pages/volunteersignup/volunteersignup';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    OrderForm,
    OrderSummary,
    PartnerProfile,
    PartnerSignUp,
    VolunteerProfile,
    VolunteerSignUp
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    OrderForm,
    OrderSummary,
    PartnerProfile,
    PartnerSignUp,
    VolunteerProfile,
    VolunteerSignUp
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
