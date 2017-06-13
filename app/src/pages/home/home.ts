import { Component, OnInit } from '@angular/core';
import { NavController } from 'ionic-angular';
import { VolunteerSignUp } from '../volunteersignup/volunteersignup';
import { PartnerSignUp } from '../partnersignup/partnersignup';
import { SignUp } from '../signup/signup';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Http, Response } from '@angular/http';
import { environment } from '../../environments/environment';
import { Auth } from '../../app/auth.service'
import 'rxjs/add/operator/toPromise';

@Component({
	selector: 'page-home',
	templateUrl: 'home.html'
})
export class HomePage implements OnInit {

	private login: FormGroup;

	constructor(public navCtrl: NavController,
				private fb: FormBuilder,
				private http: Http,
				private auth: Auth) {}

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
			const auth = this.login.getRawValue();
			const uri = environment.uri + 'users?username=' + auth.username;
			this.http.get(uri, auth).toPromise()
			.then((result: Response) => result.json())
			.then((json: Object) => this.auth.addUser(json[0]))
			.catch(e => console.log(e))
		}
	}
}
