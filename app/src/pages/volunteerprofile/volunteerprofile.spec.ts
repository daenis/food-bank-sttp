import { async } from '@angular/core/testing';
import { VolunteerProfile } from './volunteerprofile';
import { TestUtils } from '../../test';

describe('VolunteerProfile', () => {
	let fixture: any;
	let instance: any;
	beforeEach(async(() => TestUtils.beforeEachCompiler([VolunteerProfile]).then(compiled => {
		fixture = compiled.fixture;
		instance = compiled.instance;
	})));

	it('should be able to load', async(() => {
		const volunteerprofile = fixture.debugElement.componentInstance;
		expect(volunteerprofile).toBeTruthy();
	}));
})
