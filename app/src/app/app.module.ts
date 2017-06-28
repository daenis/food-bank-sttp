import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule, ToastController } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { HomePage } from '../pages/home/home';
import { MyApp } from './app.component';
import { OrderForm } from '../pages/orderform/orderform';
import { PartnerProfile } from '../pages/partnerprofile/partnerprofile';
import { VolunteerProfile } from '../pages/volunteerprofile/volunteerprofile';
import { SignUp } from '../pages/signup/signup';
import { HttpModule, JsonpModule } from '@angular/http';
import { ProductListComponent } from '../pages/product/product-list.component';
import { ProductDetailComponent } from '../pages/product/product-detail.component';
import { Auth } from './auth.service';

@NgModule({
	declarations: [
		MyApp,
		HomePage,
		OrderForm,
		PartnerProfile,
		VolunteerProfile,
		SignUp,
		ProductListComponent,
		ProductDetailComponent
	],
	imports: [
		BrowserModule,
		HttpModule,
		JsonpModule,
		IonicModule.forRoot(MyApp)
	],
	bootstrap: [IonicApp],
	entryComponents: [
		MyApp,
		HomePage,
		OrderForm,
		PartnerProfile,
		VolunteerProfile,
		SignUp,
		ProductListComponent,
		ProductDetailComponent
	],
	providers: [
		StatusBar,
		SplashScreen,
		Auth,
		{provide: ErrorHandler, useClass: IonicErrorHandler},
		ToastController
	]
})
export class AppModule {}
