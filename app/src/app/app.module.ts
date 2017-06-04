import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { PartnerPage } from '../pages/list/list';
import { OrderForm } from '../pages/orderform/orderform';
import { ProductForm } from '../pages/productform/productform';
import { Volunteer } from '../pages/volunteer/volunteer';
import { OrderSummaryPage } from '../pages/ordersummarypage/ordersummarypage';



import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    PartnerPage,
    OrderForm,
    ProductForm,
    Volunteer,
    OrderSummaryPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    PartnerPage,
    OrderForm,
    ProductForm,
    Volunteer,
    OrderSummaryPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
