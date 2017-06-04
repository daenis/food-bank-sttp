import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { Products } from './products';
import { OrderForm } from '../orderform/orderform';


@Component({
  selector: 'page-productform',
  templateUrl: 'productform.html'
})
export class ProductForm {

    private productNumber = document.getElementById("Product#");
    private description = document.getElementById("Description");
    private quantity = document.getElementById("Quantity");
    private totalprice = document.getElementById("TotalPrice");

    constructor() {}

    getFoodDescription(foodIDAsString: string): string {
        for (let product in Products) {
            if (product === foodIDAsString)
            return "";
        }
    }

}

