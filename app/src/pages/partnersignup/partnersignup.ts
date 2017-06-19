import { Component, OnInit } from '@angular/core';
import { NavController } from 'ionic-angular';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment'
import 'rxjs/add/operator/toPromise';

@Component({
	selector: 'partner-signup',
	templateUrl: 'partnersignup.html'
})
export class PartnerSignup implements OnInit {
	private form: FormGroup;

	constructor(public navCtrl: NavController,
				private fb: FormBuilder,
				private http: Http) {}
	public ngOnInit() {
		this.form = this.fb.group({
			organizationName: ['', Validators.minLength(2)],
			organizationUserName: ['', Validators.minLength(5)],
			organizationEmail: ['',
				Validators.required],
			organizationPassword: ['', Validators.required],
			organizationPhoneNumber: ['', Validators.required],
			organizationAddress: ['', Validators.required], validationCode: ['', Validators.required]
		})
	}

	public goBack(): void {
		this.navCtrl.pop();
	}

	public submit(): void {
		if (this.form.valid) {
			const result = this.parseForm(this.form.getRawValue());
			const uri = environment.uri + 'data/partners/';
			this.http.post(uri, result).toPromise()
			.then(e => this.goBack())
			.catch(e => console.warn(e))
		}
	}

	private parseForm(form: Object): Object {
		return ({
			partnerName: form['organizationName'],
			partnerUsername: form['organizationUserName'],
			partnerAddress: form['organizationAddress'],
			partnerEmail: form['organizationEmail'],
			partnerPassword: form['organizationPassword'],
			partnerPhone: form['organizationPhoneNumber'], partnerCode: form['validationCode']
		})
	}
}
