import { async } from '@angular/core/testing';
import { OrderForm } from './orderform';
import { TestUtils } from '../../test';

describe('OrderForm', () => {
	let fixture: any;
	let instance: any;
	beforeEach(async(() => TestUtils.beforeEachCompiler([OrderForm]).then(compiled => {
		fixture = compiled.fixture;
		instance = compiled.instance;
	})));

	it('should be able to load', async(() => {
		const orderform = fixture.debugElement.componentInstance;
		expect(orderform).toBeTruthy();
	}));

	it('should do something async', (done) => {
		setTimeout(() => {
			expect(true).toBe(true);
			done();
		}, 2000);
	});
	
})
