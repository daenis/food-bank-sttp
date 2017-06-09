import { TestBed, async } from '@angular/core/testing';
import { NavController, IonicModule } from 'ionic-angular';
import { OrderSummary } from './ordersummary';
import { TestUtils } from '../../test';

describe('OrderSummary', () => {
  let fixture: any;
  let instance: any;
  beforeEach(async(() => TestUtils.beforeEachCompiler([OrderSummary]).then(compiled => {
    fixture = compiled.fixture;
    instance = compiled.instance;
  })));
  it('should be able to load', async(() => {
    const ordersummary = fixture.debugElement.componentInstance;
    expect(ordersummary).toBeTruthy();
  }));
})
