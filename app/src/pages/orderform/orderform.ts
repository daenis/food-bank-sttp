import { Component, OnInit, OnChanges } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/environment';
import { Product } from '../product/product';
import { OrderFormService } from './orderform.service';
import { Auth } from '../../app/auth.service';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';

@Component({
	selector: 'page-orderform',
	templateUrl: 'orderform.html',
	providers: [OrderFormService]
})
export class OrderForm implements OnInit {
	
	private errorMessage: string;
	private products: Product[];
	private productsTotal: number;
	private users: String[];

	constructor(private http: Http,
		private navController: NavController,
		private orderFormService: OrderFormService,
		public auth: Auth) { }

	public ngOnInit(): void {
		this.orderFormService.getOrdersPromise()
			.then(products => this.updateProduct(products),
			error => this.errorMessage = <any> error)
	}

	private updateProduct(data: Product[]) {
		this.products = data
	}

	public deletePickUpRequest(category: string) {
		this.orderFormService.removeFromPickUpBoard(category)
			.then(e => this.orderFormService.getOrdersPromise())
			.then(products => this.updateProduct(products))
	}

	public determineView() {
		if (this.auth.getUserType() === "farmrep") {
			return true;
		} else {
			return false;
		}
	}

	public goBack() {
		this.navController.pop();
	}

}
