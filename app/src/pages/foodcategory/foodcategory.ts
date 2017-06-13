import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { HomePage } from  '../home/home';

@Component({
	selector: 'page-foodcategory',
	templateUrl: 'foodcategory.html'
})

export class FoodCategory {

		constructor(public navCtrl:NavController) {

		}
}
