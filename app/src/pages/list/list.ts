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
    // If we navigated to this page, we will have an item available as a nav param
    this.selectedItem = navParams.get('item');

    // Let's populate this page with some filler content for funzies
    this.icon = 'wifi';

    this.items = [];

    this.items.push({
      title: 'Place Order',
      icon: this.icon
    })

    this.items.push({
      title: 'View Available Items',
      icon: this.icon
    })

  this.items.push({
      title: 'View Item Prices',
      icon: this.icon
    })

  }

  itemTapped(event) {
    // That's right, we're pushing to ourselves!
    this.navCtrl.push(OrderForm);
  }
}
