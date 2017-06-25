import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { HomePage } from '../home/home';
import { ProductListComponent } from '../product/product-list.component';
import { Auth } from '../../app/auth.service';
import { User } from '../../app/user';

@Component({
	selector: 'page-partnerprofile',
	templateUrl: 'partnerprofile.html'
})
export class PartnerProfile {

		private user: User;
		public isVolunteer: boolean = false;
		
		constructor(public navCtrl: NavController, public authService: Auth) {}

		public getUser(): string {
			this.user = this.authService.getUser();
			return this.user.name;
		}

		public goToMenu() {
			this.navCtrl.setRoot(HomePage);
		}

		public goToOrderForm(isVolunteer) {
			this.navCtrl.push(ProductListComponent, isVolunteer );
		}

}
