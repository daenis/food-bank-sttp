import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

@Component({
  selector: 'page-products',
  templateUrl: 'products.html'
})
export class Products {
    
    products: {title: string, id: string, price: number}[];

    createProductsList() {
        this.products.push({title: "Vegetarian Black Soup", id: "702785", price: 0});
        this.products.push({title: "Pretzels, Frozen (45 pretzels per box)", id: "703516", price: 0})
        this.products.push({title: "Vanilla Cream Puffs (6/13.2 oz)", id: "703578", price: 1.33})
        this.products.push({title: "Oatmeal, Quick Cooking (12/14 oz)", id: "702403", price: 11.90})
        this.products.push({title: "Milk 1% Shelf Stable (12/32 oz)", id: "701570", price: 16.25})
        this.products.push({title: "Peaches in Syrup(24/15 oz)", id: "702167", price: 19.37})
        this.products.push({title: "Beef, Assorted (25 lb box)", id: "702917", price: 5.25})
        this.products.push({title: "Spaghetti w/ Meatballs (12/15 oz)", id: "702739", price: 10.27})
        this.products.push({title: "Spaghetti Sauce, Meat (12/24 oz)", id: "702783", price: 13.33})
    }
    

}