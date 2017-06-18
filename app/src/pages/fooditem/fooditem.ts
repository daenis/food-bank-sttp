import { Component, Input, OnInit } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { Product } from '../product/product';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs/Observable';
import { Http, Response } from '@angular/http';
import { OrderForm } from '../orderform/orderform';

@Component({
	selector: 'food-item',
	templateUrl: 'fooditem.html'
})

export class FoodItem implements OnInit {

		private products: Product[];
		private uri: string = environment.uri + 'api/item/category/';
		private item: String;
		private cartItems: Product[] = [];

		constructor(
				private http: Http,
				private navController: NavController,
				private navParams: NavParams
			) {}

		public ngOnInit(): void {
			this.item = this.navParams.get("category")
			this.populateFoodItems()
						.subscribe(products => this.products = products);
		}

		private populateFoodItems(): Observable<Product[]> {
			return this.http.get(this.uri + this.item)
									.map((response: Response) => {
										return <Product[]> this.generateFoodItemList(response.json());
									})
		}

		private generateFoodItemList(json: Object): Product[] {
			const list: Product[] = json["categories"].map(item => new Product(item));
			return list;
		}

		public getProductCategory(): String {
			return this.item;
		}

		public goBack() {
			this.navController.pop();
		}

		public addToOrder(product){
			console.log(this.cartItems);
			this.cartItems.push(product);
		}

		public goToOrderForm(item: string){
			this.navController.push(OrderForm, this.cartItems);
		}

		public getFoodProducts(): Product[] {
			return this.products;
		}



}
