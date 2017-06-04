import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { OrderForm } from '../orderform/orderform'

@Component({
  selector: 'page-list',
  templateUrl: 'list.html'
})

export class PartnerPage {
  selectedItem: any;
  icon: string;
  items: Array<{title: string, icon: string}>;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.selectedItem = navParams.get('item');

    this.icon = 'wifi';

    this.items = [];

    this.items.push({
      title: 'Place Order',
      icon: this.icon
      
    })

    this.items.push({
      title: 'Request Volunteers',
      icon: this.icon
    })

  // this.items.push({
  //     title: 'View Item Prices',
  //     icon: this.icon
  //   })

  }

  itemTapped(event) {
    this.navCtrl.push(OrderForm);
  }
}
