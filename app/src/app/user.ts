export class User {
	public readonly id: number;
	public readonly org: string;

	constructor (id: number, org: string) {
		this.id = id;
		this.org = org;
	}
}
