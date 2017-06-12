import { Component, OnInit } from '@angular/core';
import { NavController } from 'ionic-angular';
import { VolunteerSignUp } from '../volunteersignup/volunteersignup';
import { PartnerSignUp } from '../partnersignup/partnersignup';
import { SignUp } from '../signup/signup';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
	selector: 'page-home',
	templateUrl: 'home.html'
})
export class HomePage implements OnInit {

	private login: FormGroup;

	constructor(public navCtrl: NavController,
							private fb: FormBuilder) {}

	public goToVolunteerSignUp(): void {
		this.navCtrl.push(VolunteerSignUp);
	}
	public goToPartnerSignUp(): void {
		this.navCtrl.push(PartnerSignUp);
	}

	public goToSignUp(): void {
		this.navCtrl.push(SignUp);
	}

	public ngOnInit(): void {
		this.login = this.fb.group({
			username: ['', Validators.required],
			password: ['', Validators.required]
		})
	}

	public authenticate(): void {
		if (this.login.valid) {
			console.log(this.login.getRawValue())
		}
	}
}
