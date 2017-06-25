import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { HomePage } from  '../home/home';
import { OrderForm } from '../orderform/orderform';

@Component({
  selector: 'page-volunteerprofile',
  templateUrl: 'volunteerprofile.html'
})
export class VolunteerProfile {
  
  public isVolunteer: boolean = true;

  constructor(public navCtrl: NavController,
  public navParams: NavParams) {
  }
  

  public goToMenu(): void  {
    this.navCtrl.setRoot(HomePage);
  }

  public goToOrderForm(isVolunteer): void {

    this.navCtrl.push(OrderForm, isVolunteer );
  }


}
