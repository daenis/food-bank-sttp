import { Injectable } from '@angular/core';
import { User } from './user'

@Injectable()
export class Auth {
	private user: User;
	private refreshTime: Date;
	private loggedIn: boolean;

	constructor() {
		this.loggedIn = false;
	}

	public addUser(user: User) {
		this.user = user;
		this.refreshTime = new Date();
		this.loggedIn = true;
	}

	public isLoggedIn(): boolean {
		return this.loggedIn;
	}

}
