import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { VolunteerProfile } from '../volunteerprofile/volunteerprofile';

@Component({
  selector: 'page-volunteersignup',
  templateUrl: 'volunteersignup.html'
})
export class VolunteerSignUp {

  constructor(public navCtrl: NavController) {

  }
  goBack() {
    this.navCtrl.pop();
  }

  goToVolunteerProfile() {
    this.navCtrl.push(VolunteerProfile);
  }


}
