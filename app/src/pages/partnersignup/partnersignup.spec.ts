import { TestBed, async } from '@angular/core/testing';
import { NavController, IonicModule } from 'ionic-angular';
import { PartnerSignUp } from './partnersignup';
import { TestUtils } from '../../test';

describe('PartnerSignUp', () => {
  let fixture: any;
  let instance: any;
  beforeEach(async(() => TestUtils.beforeEachCompiler([PartnerSignUp]).then(compiled => {
    fixture = compiled.fixture;
    instance = compiled.instance;
  })));
  it('should be able to load', async(() => {
    const partnersignup = fixture.debugElement.componentInstance;
    expect(partnersignup).toBeTruthy();
  }));
})
