import { TestBed, async } from '@angular/core/testing';
import { NavController, IonicModule } from 'ionic-angular';
import { ShoppingCart } from './shoppingcart';
import { TestUtils } from '../../test';

describe('ShoppingCart', () => {
  let fixture: any;
  let instance: any;
  beforeEach(async(() => TestUtils.beforeEachCompiler([ShoppingCart]).then(compiled => {
    fixture = compiled.fixture;
    instance = compiled.instance;
  })));
  it('should be able to load', async(() => {
    const shoppingcart = fixture.debugElement.componentInstance;
    expect(shoppingcart).toBeTruthy();
  }));
})