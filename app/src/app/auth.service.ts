import { Injectable } from '@angular/core';
import { User } from './user'

@Injectable()
export class Auth {
	private user: User;
	private userType: string;
	private refreshTime: Date;
	private loggedIn: boolean;
	private logoutTime: Date;

	constructor() {
		this.loggedIn = false;
	}

	public addUser(user: User) {
		this.user = user;
		this.userType = user["type"];
		this.refreshTime = new Date();
		this.loggedIn = true;
	}

	public isLoggedIn(): boolean {
		return this.loggedIn;
	}

	public getUser(): User {
		return this.user;
	}

	public getUserType(): string {
		return this.userType;
	}

	public logout(): void {
		this.user = undefined;
		this.logoutTime = new Date();
		this.loggedIn = false;
	}

}
