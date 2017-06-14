import { TestBed, async } from '@angular/core/testing';
import { NavController, IonicModule } from 'ionic-angular';
import { FoodItem } from './fooditem';
import { TestUtils } from '../../test';

describe('FoodItem', () => {
	let fixture: any;
	let instance: any;
	beforeEach(async(() => TestUtils.beforeEachCompiler([FoodItem]).then(compiled => {
		fixture = compiled.fixture;
		instance = compiled.instance;
	})));
	it('should be able to load', async(() => {
		const fooditem = fixture.debugElement.componentInstance;
		expect(fooditem).toBeTruthy();
	}));
})
