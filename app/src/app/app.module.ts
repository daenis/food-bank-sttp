import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { FoodCategory } from '../pages/foodcategory/foodcategory';
import { FoodItem } from '../pages/fooditem/fooditem';
import { HomePage } from '../pages/home/home';
import { MyApp } from './app.component';
import { OrderForm } from '../pages/orderform/orderform';
import { OrderSummary } from '../pages/ordersummary/ordersummary';
import { PartnerProfile } from '../pages/partnerprofile/partnerprofile';
import { PartnerSignUp } from '../pages/partnersignup/partnersignup';
import { VolunteerProfile } from '../pages/volunteerprofile/volunteerprofile';
import { VolunteerSignUp } from '../pages/volunteersignup/volunteersignup';
import { ShoppingCart } from '../pages/shoppingcart/shoppingcart';
import { SignUp } from '../pages/signup/signup';
import { ProductListPromise } from '../pages/foodcategory/productlist.promise';
import { HttpModule, JsonpModule } from '@angular/http';

@NgModule({
	declarations: [
		MyApp,
		HomePage,
		OrderForm,
		OrderSummary,
		PartnerProfile,
		PartnerSignUp,
		VolunteerProfile,
		VolunteerSignUp,
		FoodItem,
		FoodCategory,
		ShoppingCart,
		ProductListPromise,
		SignUp
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
		PartnerSignUp,
		VolunteerProfile,
		VolunteerSignUp,
		FoodItem,
		FoodCategory,
		ShoppingCart,
		ProductListPromise,
		SignUp
	],
	providers: [
		StatusBar,
		SplashScreen,
		{provide: ErrorHandler, useClass: IonicErrorHandler}
	]
})
export class AppModule {}
