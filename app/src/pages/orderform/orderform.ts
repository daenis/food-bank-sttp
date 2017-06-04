import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { ProductForm } from '../productform/productform';

@Component({
  selector: 'page-orderform',
  templateUrl: 'orderform.html'
})
export class OrderForm {
  
    private agencyName = document.getElementById("AgencyName");
    private agencyAccountNumber = document.getElementById("Account#");
    private agencyContact = document.getElementById("AgencyContact");
    private agencyEmail = document.getElementById("AgencyEmail");
    private agencyPhoneNumber = document.getElementById("AgencyPhone#");
    private agencyFaxNumber = document.getElementById("AgencyFax#");
    private pickUpDate = document.getElementById("PickUp");
    private deliveryDate = document.getElementById("Delivery");
    
    constructor(public navCtrl: NavController) {}

    itemTapped(event) {
    // Nav to product form
    this.navCtrl.push(ProductForm);
  }
}