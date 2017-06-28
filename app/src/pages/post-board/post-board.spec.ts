import { async } from '@angular/core/testing';
import { PostBoard } from './post-board';
import { TestUtils } from '../../test';

describe('PostBoard', () => {
	let fixture: any;
	let instance: any;
	beforeEach(async(() => TestUtils.beforeEachCompiler([PostBoard]).then(compiled => {
		fixture = compiled.fixture;
		instance = compiled.instance;
	})));

	it('should be able to load', async(() => {
		const postboard = fixture.debugElement.componentInstance;
		expect(postboard).toBeTruthy();
	}));

	it('should do something async', (done) => {
		setTimeout(() => {
			expect(true).toBe(true);
			done();
		}, 2000);
	});
	
})
