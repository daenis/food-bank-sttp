import { Component, OnInit, OnChanges } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/environment';
import { Product } from '../product/product';
import { PostBoardService } from './post-board.service';
import { Auth } from '../../app/auth.service';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';

@Component({
	selector: 'page-postboard',
	templateUrl: 'post-board.html',
	providers: [PostBoardService]
})
export class PostBoard implements OnInit {
	
	private errorMessage: string;
	private products: Product[];
	private productsTotal: number;
	private users: String[];

	constructor(private http: Http,
		private navController: NavController,
		private postBoardService: PostBoardService,
		public auth: Auth) { }

	public ngOnInit(): void {
		this.postBoardService.getOrdersPromise()
			.then(products => this.updateProduct(products),
			error => this.errorMessage = <any> error)
	}

	private updateProduct(data: Product[]) {
		this.products = data
	}

	public deletePickUpRequest(category: string) {
		this.postBoardService.removeFromPickUpBoard(category)
			.then(e => this.postBoardService.getOrdersPromise())
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
