import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { Products } from './products';
import { OrderForm } from '../orderform/orderform';


@Component({
  selector: 'page-productform',
  templateUrl: 'productform.html'
})
export class ProductForm {

    productNumber1;
    quantity1;
    productNumber2;
    quantity2;
    /*
    productNumber3 = document.getElementById("Food3ID");
    quantity3 = document.getElementById("Food3Quantity");
    productNumber4 = document.getElementById("Food4ID");
    quantity4 = document.getElementById("Food4Quantity");
    productNumber5 = document.getElementById("Food5ID");
    quantity5 = document.getElementById("Food5Quantity");

    productNumber6 = document.getElementById("Food6ID");
    quantity6 = document.getElementById("Food6Quantity");
    productNumber7 = document.getElementById("Food7ID");
    quantity7 = document.getElementById("Food7Quantity");
    productNumber8 = document.getElementById("Food8ID");
    quantity8 = document.getElementById("Food8Quantity");
    productNumber9 = document.getElementById("Food9ID");
    quantity9 = document.getElementById("Food9Quantity");
    productNumber10 = document.getElementById("Food10ID");
    quantity10 = document.getElementById("Food10Quantity");
*/
    constructor(public navCtrl: NavController) {
    }

    getFoodItem1(): any[] {
        this.productNumber1 = document.getElementById("Food1ID");
        this.quantity1 = document.getElementById("Food1Quantity");
        return [this.productNumber1, this.quantity1];
    }
    getFoodItem2(): any[] {
        this.productNumber2 = document.getElementById("Food2ID");
        this.quantity2 = document.getElementById("Food2Quantity");
        return [this.productNumber2, this.quantity2];
    }

    itemTapped(event) {
        let foodList = this.getFoodItem1();
        foodList.concat(this.getFoodItem2());
        for (let index = 0; index < foodList.length; index++ ) {
        }
    // Nav to product form
    this.navCtrl.push(ProductForm);
  }

}

