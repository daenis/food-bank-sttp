import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { HomePage } from  '../home/home';

@Component({
  selector: 'page-volunteerprofile',
  templateUrl: 'volunteerprofile.html'
})
export class VolunteerProfile {

  constructor(public navCtrl: NavController) {

  }

  goToMenu() {
    this.navCtrl.setRoot(HomePage);
  }

}
