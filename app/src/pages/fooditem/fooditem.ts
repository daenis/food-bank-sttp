import { Component, Input, OnInit } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { Product } from '../product/product';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs/Observable';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { OrderForm } from '../orderform/orderform';

@Component({
	selector: 'food-item',
	templateUrl: 'fooditem.html'
})

export class FoodItem implements OnInit {

	private products: Product[];
	private uri: string = environment.uri + 'api/item/category/';
	private item: String;

	constructor(
		private http: Http,
		private navController: NavController,
		private navParams: NavParams
	) { }

	public ngOnInit(): void {
		this.item = this.navParams.get("category")
		this.populateFoodItems()
			.subscribe(products => this.products = products);
	}

	private populateFoodItems(): Observable<Product[]> {
		return this.http.get(this.uri + this.item)
			.map((response: Response) => {
				return <Product[]>this.generateFoodItemList(response.json());
			})
	}

	public addSelectedProductToOrder(product) {
		return this.http.put(environment.uri + 'api/order/', product);
	}
	// Adds item to shopping cart on-click of "Add to cart"
	public addToOrder(product) {
		this.addSelectedProductToOrder(product).subscribe(
			data => {
				this.getFoodProducts();
				return true;
			}
		);
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

	public goToOrderForm() {
		this.navController.push(OrderForm);
	}

	public getFoodProducts(): Product[] {
		return this.products;
	}

}
