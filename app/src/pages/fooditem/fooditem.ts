import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Product } from '../foodcategory/product';
import { environment } from '../../environments/environment';


@Component({
  selector: 'page-fooditem',
  templateUrl: 'fooditem.html'
})

export class FoodItem {

		private products: Product[]; 

    constructor(public navCtrl:NavController){
		}




		
}
