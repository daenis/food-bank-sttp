import { Injectable } from '@angular/core';

@Injectable()
export class Auth {
	private id: number;
	private org: string;
	private refreshTime: Date;
	private loggedIn: boolean;

	constructor() {
		this.loggedIn = false;
	}

	public addUser(user: Object) {
		this.id = user['id'];
		this.org = user['org'];
		this.refreshTime = new Date();
		this.loggedIn = true;
	}

	public isLoggedIn(): boolean {
		return this.loggedIn;
	}

}
