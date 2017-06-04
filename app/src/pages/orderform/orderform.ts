import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { ProductForm } from '../productform/productform';

@Component({
  selector: 'page-orderform',
  templateUrl: 'orderform.html'
})
export class OrderForm {
    
    private AgencyName;
    private AgencyNumber;
    private AgencyContact;
    private AgencyEmail;
    private AgencyPhoneNumber;
    private AgencyFaxNumber;
    private PickUp;
    private Delivery;

    constructor(public navCtrl: NavController) {}

    getAgencyName(): string {return this.AgencyName;}
    getAgencyNumber(): string {return this.AgencyNumber;}
    getAgencyContact(): string {return this.AgencyContact;}
    getAgencyEmail(): string {return this.AgencyEmail;}
    getAgencyPhoneNumber(): string {return this.AgencyPhoneNumber;}
    getAgencyFaxNumber(): string {return this.AgencyFaxNumber;}
    getPickup(): string {return this.PickUp;}
    getDelivery(): string {return this.Delivery;}

    itemTapped(event) {
    this.navCtrl.push(ProductForm);
  }
}
