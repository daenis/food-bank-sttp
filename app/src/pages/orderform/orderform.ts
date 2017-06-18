import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-orderform',
  templateUrl: 'orderform.html'
})
export class OrderForm {

  constructor(public navController: NavController) {

  }

	public goBack() {
		this.navController.pop();
	}

}
