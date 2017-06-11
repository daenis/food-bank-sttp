import { Component, OnInit } from '@angular/core';
import { NavController } from 'ionic-angular';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Http } from '@angular/http';

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
				Validators.pattern('^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$')],
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
		}
	}
}
