import { Component, OnInit } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { Product } from './product';
import { ProductService } from './product.service';
//import { ProductDetailComponent } from './product-detail.component';
import { FoodItem } from '../fooditem/fooditem';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment'
import { OrderForm } from '../orderform/orderform';

@Component({
	templateUrl: './product-list.component.html',
	providers: [ProductService]
})
export class ProductListComponent implements OnInit {
	private pageTitle: string = 'Categories';
	private errorMessage: string;
	private products: String[];
	private form: FormGroup;

	constructor(
		private _productService: ProductService,
		private navCtrl: NavController,
		private navParams: NavParams,
		private fb: FormBuilder,
		private http: Http) {
	}

	public ngOnInit(): void {
		this.getForm();
		// this._productService.getProducts()
		// 	.subscribe(products => this.products = products,
		// 	error => this.errorMessage = <any>error);
	}

	// public goToProductDetail(category: string) {
	// 	const form = this.parseForm(this.form.getRawValue());
	// 	console.log(form)
	// 	console.log(category)
	// 	this.navCtrl.push(FoodItem, { category }, form);
	// }
	public submit(): void {
			const result = this.parseForm(this.form.getRawValue());
			const uri = environment.uri + 'api/order';
			this.http.put(uri, result).toPromise()
				.catch(e => console.warn(e))
	}

	public getForm() {
		this.form = this.fb.group({
			category: [''],
			description: [''],
			quantity: ['']
		})
	}

	private parseForm(form: Object): Object {
		return ({
			category: form['category'],
			description: form['description'],
			quantity: form['quantity']
		})
	}

	public goBack(): void {
		this.navCtrl.pop();
	}

	public goToOrderForm() {
		this.navCtrl.push(OrderForm);
	}

}
