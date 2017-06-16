import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { HomePage } from '../home/home';
import { ProductListComponent } from '../product/product-list.component';


@Component({
	selector: 'page-partnerprofile',
	templateUrl: 'partnerprofile.html'
})
export class PartnerProfile {

		constructor(public navCtrl: NavController) {}

		public goToMenu() {
			this.navCtrl.setRoot(HomePage);
		}

		public goToOrderForm() {
			this.navCtrl.push(ProductListComponent);
		}

}
