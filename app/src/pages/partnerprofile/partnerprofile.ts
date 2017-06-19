import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { HomePage } from '../home/home';
import { ProductListComponent } from '../product/product-list.component';
import { Auth } from '../../app/auth.service';
import { User } from '../../app/user';

@Component({
	selector: 'page-partnerprofile',
	templateUrl: 'partnerprofile.html'
})
export class PartnerProfile {

		constructor(public navCtrl: NavController, public authService: Auth) {}

		public getUser(): User {
			return this.authService.getUser();
		}

		public goToMenu() {
			this.navCtrl.setRoot(HomePage);
		}

		public goToOrderForm() {
			this.navCtrl.push(ProductListComponent);
		}

}
