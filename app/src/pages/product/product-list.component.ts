import { Component, OnInit } from '@angular/core';
import { NavController, NavParams, ToastController } from 'ionic-angular';
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
		private http: Http,
		private toastCtrl: ToastController) {
	}

	public ngOnInit(): void {
		this.getForm();
	}

	private postToPickUpBoard(): void {
		const result = this.parseForm(this.form.getRawValue());
		const uri = environment.uri + 'api/order';
		this.http.put(uri, result).toPromise()
			.catch(e => console.warn(e))
		this.confirmPostToPickUpBoard();
		this.clearForm();
	}

	private clearForm(): void {
		this.form.reset();
	}

	private confirmPostToPickUpBoard() {
		let toast = this.toastCtrl.create({
			message: 'Request has been posted',
			duration: 2000,
			position: 'middle'
		});
		toast.present();
	}

	private getForm() {
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

	private goBack(): void {
		this.navCtrl.pop();
	}

	private goToOrderForm() {
		this.navCtrl.push(OrderForm);
	}

}
