import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { HomePage } from  '../home/home';
import { PostBoard } from '../post-board/post-board';

@Component({
  selector: 'page-volunteerprofile',
  templateUrl: 'volunteerprofile.html'
})
export class VolunteerProfile {

  constructor(public navCtrl: NavController,
  public navParams: NavParams) {
  }

  public goToOrderForm(): void {
    this.navCtrl.push(PostBoard);
  }  
  
  public goToMenu(): void  {
    this.navCtrl.setRoot(HomePage);
  }


}
