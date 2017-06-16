import { Component, Input, OnInit } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { Product } from '../product/product';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs/Observable';
import { Http, Response } from '@angular/http';

@Component({
	selector: 'food-item',
	templateUrl: 'fooditem.html'
})

export class FoodItem implements OnInit {

		private products: Product[];
		private uri: string = environment.uri + "api/categories/"
		private item: String;

		constructor(
				private http: Http,
				private navController: NavController,
				private navParams: NavParams
			) {}

		public ngOnInit(): void {
			console.log('Happening')
			this.item = this.navParams.get("category")
			console.log(this.item);
			this.populateFootItems()
						.subscribe(products => this.products = products);
		}

		private populateFootItems(): Observable<Product[]> {
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

		public getFoodProducts(): Product[] {
			return this.products;
		}

}
