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
    productNumber3;
    quantity3;
    productNumber4;;
    quantity4;
    productNumber5;
    quantity5;
    returnList;

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
    getFoodItem3(): any[] {
        this.productNumber3 = document.getElementById("Food3ID");
        this.quantity3 = document.getElementById("Food3Quantity");
        return [this.productNumber3, this.quantity3];
    }
    getFoodItem4(): any[] {
        this.productNumber4 = document.getElementById("Food4ID");
        this.quantity4 = document.getElementById("Food4Quantity");
        return [this.productNumber4, this.quantity4];
    }

    getFoodItem5(): any[] {
        this.productNumber5 = document.getElementById("Food5ID");
        this.quantity5 = document.getElementById("Food5Quantity");
        return [this.productNumber5, this.quantity5];
    }

    consolidateFoodItems(): any[] {
        let foodList = this.getFoodItem1();
        foodList.push(this.getFoodItem2());
        foodList.push(this.getFoodItem3());
        foodList.push(this.getFoodItem4());
        foodList.push(this.getFoodItem5());
        return foodList;
    }

    eliminateIncompleteEntries(foodList: any[]): void {
        this.returnList = [];
        for (let index = 0; index < foodList.length; index++ ) {
            if (foodList[index][0] && foodList[index][1] !== "") {
                this.returnList.push(foodList[index]);
            }
        }
    }

    getConsolidatedFoodList(): any[] {
        return this.returnList;
    }

    itemTapped(event) {
        let foodList = this.consolidateFoodItems();
        this.eliminateIncompleteEntries(foodList);
        //this.navCtrl.push(OrderSummaryPage);
    }

}

