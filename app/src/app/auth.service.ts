import { Injectable } from '@angular/core';
import { User } from './user'

@Injectable()
export class Auth {
	private user: User;
	private refreshTime: Date;
	private loggedIn: boolean;
	private logoutTime: Date;

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

	public getUser(): User {
		return this.user;
	}

	public logout(): void {
		this.user = undefined;
		this.logoutTime = new Date();
		this.loggedIn = false;
	}

}
