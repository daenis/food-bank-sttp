import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { VolunteerSignUp } from '../volunteersignup/volunteersignup';
import { PartnerSignUp } from '../partnersignup/partnersignup';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController) {
    
  }
  goToVolunteerSignUp(){
    this.navCtrl.push(VolunteerSignUp);
  }
  goToPartnerSignUp(){
    this.navCtrl.push(PartnerSignUp);
  }
  


}
