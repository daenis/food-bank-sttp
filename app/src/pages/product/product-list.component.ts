import { Component, OnInit } from '@angular/core';
import { NavController, NavParams, ToastController } from 'ionic-angular';
import { Product } from './product';
import { ProductService } from './product.service';
import { FoodItem } from '../fooditem/fooditem';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment'
import { OrderForm } from '../orderform/orderform';

@Component({
	templateUrl: './product-list.component.html',
	providers: [ProductService, ToastController]
})
export class ProductListComponent implements OnInit {
	private pageTitle: string = 'Categories';
	private errorMessage: string;
	private products: String[];
	private form: FormGroup;
	private hideHelp: boolean = true;
	private help: string =
	"Use a general category such as : Fruit, Vegtables, Meat, Dairy, Non-Food Product." +
	"Briefly describe the donation type, include details like Perishable or Non-Perishable. \r" +
	"Related to the weight, amount of boxes, or bushels.";

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
	// Sends input from fields to order endpoint
	// only if fields have value, can be anything as long
	// as it is not empty
	private postToPickUpBoard(): void {
		if (this.form.valid) {
		const result = this.parseForm(this.form.getRawValue());
		const uri = environment.uri + 'api/order';
		this.http.put(uri, result).toPromise()
			.catch(e => console.warn(e))
		this.confirmPostToPickUpBoard();
		this.clearForm();
		} else {
			this.notifyInvalidEntry();
		}
	}
	// Resets forms to empty
	// fires off when post is clicked
	private clearForm(): void {
		this.form.reset();
	}
	// Pop up notification when post is sent
	private confirmPostToPickUpBoard(): void {
		let toast = this.toastCtrl.create({
			message: 'Request has been posted',
			duration: 2000,
			position: 'middle'
		});
		toast.present();
	}
	// Pop up notification when fields are invalid
	private notifyInvalidEntry(): void {
		let toast = this.toastCtrl.create({
			message: 'All fields are required. Please complete all fields',
			duration: 2000,
			position: 'middle'
		});
		toast.present();
	}
	// Retrieves the field information that is 
	// put into the text boxes - all fields require input
	private getForm() {
		this.form = this.fb.group({
			category: ['', Validators.required],
			description: ['', Validators.required],
			quantity: ['', Validators.required]
		})
	}
	// Parses input into object format to send
	private parseForm(form: Object): Object {
			return ({
				category: form['category'],
				description: form['description'],
				quantity: form['quantity']
			})
	}

	private showOrHideHelp(): void {
		if (this.hideHelp === true) {
			this.hideHelp = false;
		} else {
			this.hideHelp = true;
		}
	}

	private isHelpOn(): boolean {
		if (this.hideHelp === true) {
			return false;
		} else {
			return true;
		}
	}

	// Pops off stack, goes back a page
	private goBack(): void {
		this.navCtrl.pop();
	}
	// Pushes on stack, goes to orderform
	private goToOrderForm() {
		this.navCtrl.push(OrderForm);
	}

}
