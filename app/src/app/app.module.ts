import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { FoodItem } from '../pages/fooditem/fooditem';
import { HomePage } from '../pages/home/home';
import { MyApp } from './app.component';
import { OrderForm } from '../pages/orderform/orderform';
import { OrderSummary } from '../pages/ordersummary/ordersummary';
import { PartnerProfile } from '../pages/partnerprofile/partnerprofile';
import { VolunteerProfile } from '../pages/volunteerprofile/volunteerprofile';
import { SignUp } from '../pages/signup/signup';
import { HttpModule, JsonpModule } from '@angular/http';
import { ProductListComponent } from '../pages/product/product-list.component';
import { ProductFilterPipe } from '../pages/product/product-filter.pipe';
import { ProductDetailComponent } from '../pages/product/product-detail.component';

@NgModule({
	declarations: [
		MyApp,
		HomePage,
		OrderForm,
		OrderSummary,
		PartnerProfile,
		VolunteerProfile,
		FoodItem,
		SignUp,
		ProductListComponent,
		ProductDetailComponent,
		ProductFilterPipe
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
		OrderSummary,
		PartnerProfile,
		VolunteerProfile,
		FoodItem,
		SignUp,
		ProductListComponent,
		ProductDetailComponent
	],
	providers: [
		StatusBar,
		SplashScreen,
		{provide: ErrorHandler, useClass: IonicErrorHandler}
	]
})
export class AppModule {}
