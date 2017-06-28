import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule, ToastController } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { HomePage } from '../pages/home/home';
import { MyApp } from './app.component';
import { PostBoard } from '../pages/post-board/post-board';
import { PartnerProfile } from '../pages/partnerprofile/partnerprofile';
import { VolunteerProfile } from '../pages/volunteerprofile/volunteerprofile';
import { SignUp } from '../pages/signup/signup';
import { HttpModule, JsonpModule } from '@angular/http';
import { ProductListComponent } from '../pages/product/product-list.component';
import { Auth } from './auth.service';

@NgModule({
	declarations: [
		MyApp,
		HomePage,
		PostBoard,
		PartnerProfile,
		VolunteerProfile,
		SignUp,
		ProductListComponent
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
		PostBoard,
		PartnerProfile,
		VolunteerProfile,
		SignUp,
		ProductListComponent
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
