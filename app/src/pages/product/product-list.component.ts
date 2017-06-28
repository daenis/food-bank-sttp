import { Component, OnInit } from '@angular/core';
import { NavController, NavParams, ToastController } from 'ionic-angular';
import { Product } from './product';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment'
import { PostBoard } from '../post-board/post-board';

@Component({
	templateUrl: './product-list.component.html',
	providers: [ToastController]
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
		private navCtrl: NavController,
		private navParams: NavParams,
		private fb: FormBuilder,
		private http: Http,
		private toastCtrl: ToastController) {
	}

	public ngOnInit(): void {
		this.getForm();
	}

	private getForm() {
		this.form = this.fb.group({
			category: ['', Validators.required],
			description: ['', Validators.required],
			quantity: ['', Validators.required]
		})
	}

	private clearForm(): void {
		this.form.reset();
	}

	private parseForm(form: Object): Object {
			return ({
				category: form['category'],
				description: form['description'],
				quantity: form['quantity']
			})
	}

	private confirmPostToPostBoard(): void {
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

	private postToPostBoard(): void {
		if (this.form.valid) {
		const result = this.parseForm(this.form.getRawValue());
		const uri = environment.uri + 'api/order';
		this.http.put(uri, result).toPromise()
			.catch(e => console.warn(e))
		this.confirmPostToPostBoard();
		this.clearForm();
		} else {
			this.notifyInvalidEntry();
		}
	}

	private goBack(): void {
		this.navCtrl.pop();
	}

	private goToPostBoard() {
		this.navCtrl.push(PostBoard);
	}

}
