import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { OrderForm } from '../orderform/orderform';
import { OrderSummaryPage } from '../ordersummarypage/ordersummarypage'


@Component({
  selector: 'page-productform',
  templateUrl: 'productform.html'
})
export class ProductForm {

    private Food1ID;
    private Food1Quantity;
    private Food2ID;
    private Food2Quantity;
    private Food3ID;
    private Food3Quantity;
    private Food4ID;;
    private Food4Quantity;
    private Food5ID;
    private Food5Quantity;
    private returnList;

    private products = [
        {title: "Vegetarian Black Soup", id: "702785", price: 0},
        {title: "Pretzels, Frozen (45 pretzels per box)", id: "703516", price: 0},
        {title: "Vanilla Cream Puffs (6/13.2 oz)", id: "703578", price: 1.33},
        {title: "Oatmeal, Quick Cooking (12/14 oz)", id: "702403", price: 11.90},
        {title: "Milk 1% Shelf Stable (12/32 oz)", id: "701570", price: 16.25},
        {title: "Peaches in Syrup(24/15 oz)", id: "702167", price: 19.37},
        {title: "Beef, Assorted (25 lb box)", id: "702917", price: 5.25},
        {title: "Spaghetti w/ Meatballs (12/15 oz)", id: "702739", price: 10.27},
        {title: "Spaghetti Sauce, Meat (12/24 oz)", id: "702783", price: 13.33}
    ];

    constructor(public navCtrl: NavController) {
    }

    getFoodItem1(): any[] {
        return [this.Food1ID, this.Food1Quantity];
    }
    getFoodItem2(): any[] {
        return [this.Food2ID, this.Food2Quantity];
    }
    getFoodItem3(): any[] {
        return [this.Food3ID, this.Food3Quantity];
    }
    getFoodItem4(): any[] {
        return [this.Food4ID, this.Food4Quantity];
    }
    getFoodItem5(): any[] {
        return [this.Food5ID, this.Food5Quantity];
    }

    consolidateFoodItems(): any[] {
        let foodList = [];
        foodList.push(this.getFoodItem1());
        foodList.push(this.getFoodItem2());
        foodList.push(this.getFoodItem3());
        foodList.push(this.getFoodItem4());
        foodList.push(this.getFoodItem5());
        return foodList;
    }

    eliminateIncompleteEntries(foodList: any[]): void {
        this.returnList = [];
        for (let index = 0; index < foodList.length; index++) {
            if (foodList[index][0] !== undefined && foodList[index][1] !== undefined) {
                this.returnList.push(foodList[index]);
            }
        }
    }

    eliminateNonExistantProducts(foodList: any[]): void {
        let allProductsList = this.getProducts();
        let availableProductIDs = this.createIDList();
        for (let index = 0; index < foodList.length; index++) {
            if (availableProductIDs.indexOf(foodList[index][0]) === -1) {
                foodList.splice(index, 1);
            } 
        }
    }

    getConsolidatedFoodList(): any[] {
        return this.returnList;
    }

    getProducts(): any[] {
        return this.products;
    }

    createIDList(): any[] {
        let idArray: string[] = [];
        let allProducts = this.getProducts();
        for (let index = 0; index < allProducts.length; index++) {
            idArray.push(allProducts[index].id);
        }
        return idArray;
    }

    itemTapped(event) {
        this.returnList = this.consolidateFoodItems();
        this.eliminateIncompleteEntries(this.returnList);
        this.eliminateNonExistantProducts(this.returnList);
        this.navCtrl.push(OrderSummaryPage);
    }

}

