import { async } from '@angular/core/testing';
import { SignUp } from './signup';
import { TestUtils } from '../../test';

describe('VolunteerSignUp', () => {
	let fixture: any;
	let instance: any;
	beforeEach(async(() => TestUtils.beforeEachCompiler([SignUp]).then(compiled => {
		fixture = compiled.fixture;
		instance = compiled.instance;
	})));

	it('should be able to load', async(() => {
		const volunteersignup = fixture.debugElement.componentInstance;
		expect(volunteersignup).toBeTruthy();
	}));
})
