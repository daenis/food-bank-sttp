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
	providers: [ProductService]
})
export class ProductListComponent implements OnInit {
	private pageTitle: string = 'Categories';
	private errorMessage: string;
	private products: String[];
	private form: FormGroup;
	private hideCategoryHelp: boolean = true;
	private hideDescriptionHelp: boolean = true;
	private hideQuantityHelp: boolean = true;
	private categoryHelp: string = 
	"Use a general Category such as : Fruit, Vegtables, Meat, Dairy, Non-Food Product";
	private descriptionHelp: string = 
	"Briefly describe the donation type, include details like Perishable or Non-Perishable";	
	private quantityHelp: string = 
	"Related to the weight, amount of boxes, or bushels";			

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

	private clearForm(): void {
		this.form.reset();
	}

	private confirmPostToPickUpBoard(): void {
		let toast = this.toastCtrl.create({
			message: 'Request has been posted',
			duration: 2000,
			position: 'middle'
		});
		toast.present();
	}

	private notifyInvalidEntry(): void {
		let toast = this.toastCtrl.create({
			message: 'All fields are required. Please complete all fields',
			duration: 2000,
			position: 'middle'
		});
		toast.present();
	}

	private getForm() {
		this.form = this.fb.group({
			category: ['', Validators.required],
			description: ['', Validators.required],
			quantity: ['', Validators.required]
		})
	}

	private parseForm(form: Object): Object {
			return ({
				category: form['category'],
				description: form['description'],
				quantity: form['quantity']
			})
	}
	
	private showCategoryHelp(): void {
		this.hideCategoryHelp = false;
		this.hideDescriptionHelp = true;
		this.hideQuantityHelp = true;
	}

	private showDescriptionHelp(): void {
		this.hideDescriptionHelp = false;
		this.hideCategoryHelp = true;
		this.hideQuantityHelp = true;
	}

	private showQuantityHelp(): void {
		this.hideQuantityHelp = false;
		this.hideDescriptionHelp = true;
		this.hideCategoryHelp = true;
	}

	private goBack(): void {
		this.navCtrl.pop();
	}

	private goToOrderForm() {
		this.navCtrl.push(OrderForm);
	}

}
