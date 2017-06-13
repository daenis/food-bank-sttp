import { TestBed, async } from '@angular/core/testing';
import { NavController, IonicModule } from 'ionic-angular';
import { FoodCategory } from './foodcategory';
import { TestUtils } from '../../test';

describe('FoodCategory', () => {
	let fixture: any;
	let instance: any;
	beforeEach(async(() => TestUtils.beforeEachCompiler([FoodCategory]).then(compiled => {
		fixture = compiled.fixture;
		instance = compiled.instance;
	})));
	it('should be able to load', async(() => {
		const foodcategory = fixture.debugElement.componentInstance;
		expect(foodcategory).toBeTruthy();
	}));
})
