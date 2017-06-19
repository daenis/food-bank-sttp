export class User {
	public readonly id: number;
	public readonly name: string;
	public readonly type: string;
	public readonly org: string;

	constructor (id: number, name: string, type: string, org: string) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.org = org;
	}

}
