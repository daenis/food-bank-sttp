import { Component, OnInit } from '@angular/core';
import { NavController } from 'ionic-angular';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment'

@Component({
	selector: 'page-signup',
	templateUrl: 'signup.html'
})
export class SignUp implements OnInit {
	private form: FormGroup;

	constructor(public navCtrl: NavController,
				private fb: FormBuilder,
				private http: Http) {}
	public ngOnInit() {
		this.form = this.fb.group({
			name: ['', Validators.minLength(2)],
			userName: ['', Validators.minLength(5)],
			email: ['',
				Validators.required],
			password: ['', Validators.required],
			phoneNumber: ['', Validators.required],
			address: ['']
		})
	}
	
	public goBack(): void {
		this.navCtrl.pop();
	}

	public submit(): void {
		if (this.form.valid) {
			const result = this.parseForm(this.form.getRawValue())
			const uri = environment.uri + 'users/'
			this.http.post(uri, result).toPromise()
			         .then(e => this.goBack())
					 .catch(e => console.warn(e))
		}
	}

	private parseForm(form: Object): Object {
		return ({
			name: form['name'],
			username: form['username'],
			address: form['address'],
			email: form['email'],
			password: form['password'],
			phone: form['phoneNumber'],
			type: 'volunteers'
		})
	}
}
