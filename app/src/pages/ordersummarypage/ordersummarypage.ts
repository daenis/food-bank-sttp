import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { OrderForm } from '../orderform/orderform';
import { ProductForm } from '../productform/productform';


@Component({
  selector: 'page-ordersummary',
  templateUrl: 'ordersummarypage.html'
})
export class OrderSummaryPage {

    private productNumber1;
    private quantity1;
    private productNumber2;
    private quantity2;
    private productNumber3;
    private quantity3;
    private productNumber4;;
    private quantity4;
    private productNumber5;
    private quantity5;
    private returnList;

    constructor(public navCtrl: NavController) {}



}