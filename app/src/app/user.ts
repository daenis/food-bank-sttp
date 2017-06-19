export class User {
	public readonly id: number;
	public readonly type: string;
	public readonly org: string;

	constructor (id: number, type: string, org: string) {
		this.id = id;
		this.type = type;
		this.org = org;
	}

}
