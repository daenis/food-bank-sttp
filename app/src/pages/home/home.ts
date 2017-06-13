import { Component, OnInit } from '@angular/core';
import { NavController } from 'ionic-angular';
import { PartnerProfile } from '../partnerprofile/partnerprofile';
import { SignUp } from '../signup/signup';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Http, Response } from '@angular/http';
import { environment } from '../../environments/environment';
import { Auth } from '../../app/auth.service'
import 'rxjs/add/operator/toPromise';
import { User } from '../../app/user'

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

	public goToSignUp(): void {
		this.navCtrl.push(SignUp);
	}

	public ngOnInit(): void {
		this.login = this.fb.group({
			username: ['', Validators.required],
			password: ['', Validators.required]
		})
	}

	private goToProfile(): void {
		if (this.auth.isLoggedIn()) {
			this.navCtrl.push(PartnerProfile);
		}
	}

	private formatUserAuthDetails(authDetails: Object) {
		return new User(authDetails[0]['id'], authDetails[0]['org']);
	}

	public authenticate(): void {
		if (this.login.valid) {
			const auth = this.login.getRawValue();
			const uri = environment.uri + 'data/users?username=' + auth.username;
			this.http.get(uri, auth).toPromise()
			.then((result: Response) => result.json())
			.then((json: Object) => this.formatUserAuthDetails(json))
			.then((user: User) => this.auth.addUser(user))
			.then(() => this.goToProfile())
			.catch(e => console.log(e))
		}
	}
}
