import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';


@Component({
  selector: 'page-fooditem',
  templateUrl: 'fooditem.html'
})

export class FoodItem {

		private referenceNumber: string;
		private totalCostPerUnit: number;
		private description: string;
		private quantityAvailable: number;

    constructor(public navCtrl:NavController){
		}

    // getReferenceNumber() {
    //     return this.referenceNumber;
    // }

    // getTotalCostPerUnit() {
    //     return this.totalCostPerUnit;
    // }

    // getDescription() {
    //     return this.description;
    // }

    // getQuantityAvailable() {
    //     return this.quantityAvailable;
    // }

    // addQuantity(number) {
    //     this.quantityAvailable += number;
    // }

    // dockQuantity(number) {
    //     if (this.quantityAvailable - number < 0) {
    //             this.quantityAvailable = 0;
    //     } else {
    //             this.quantityAvailable -= number;
    //     }
		// }
		
}
