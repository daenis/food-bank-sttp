import { Component, OnInit } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { Product } from './product';
import { ProductService } from './product.service';
//import { ProductDetailComponent } from './product-detail.component';
import { FoodItem } from '../fooditem/fooditem';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

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
		private fb: FormBuilder) {
	}
	
	public ngOnInit(): void {
		this.getForm();
		this._productService.getProducts()
			.subscribe(products => this.products = products,
			error => this.errorMessage = <any>error);
	}

	public goToProductDetail(category: string) {
		const form = this.parseForm(this.form.getRawValue());
		console.log(form)
		console.log(category)
		this.navCtrl.push(FoodItem, { category }, form);
	}

	public getForm() {
		this.form = this.fb.group({
			description: [''],
			quantity: ['']
		})
	}

	private parseForm(form: Object): Object {
		return ({
			description: form['description'],
			quantity: form['quantity']
		})
	}

	public goBack(): void {
		this.navCtrl.pop();
	}

}
