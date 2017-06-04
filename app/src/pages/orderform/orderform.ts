import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

@Component({
  selector: 'page-orderform',
  templateUrl: 'orderform.html'
})
export class OrderForm {
    //TODO - MOVE THESE TO OTHER FORM
    // private productNumber = document.getElementById("Product#");
    // private description = document.getElementById("Description");
    // private quantity = document.getElementById("Quantity");
    // private totalprice = document.getElementById("TotalPrice");
    private agencyName = document.getElementById("AgencyName");
    private agencyAccountNumber = document.getElementById("Account#");
    private agencyContact = document.getElementById("AgencyContact");
    private agencyEmail = document.getElementById("AgencyEmail");
    private agencyPhoneNumber = document.getElementById("AgencyPhone#");
    private agencyFaxNumber = document.getElementById("AgencyFax#");
    private pickUpDate = document.getElementById("PickUp");
    private deliveryDate = document.getElementById("Delivery");
    
    constructor() {}

}