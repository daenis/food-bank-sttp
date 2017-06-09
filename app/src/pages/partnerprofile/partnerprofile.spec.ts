import { TestBed, async } from '@angular/core/testing';
import { NavController, IonicModule } from 'ionic-angular';
import { PartnerProfile } from './partnerprofile';
import { TestUtils } from '../../test';

describe('PartnerProfile', () => {
  let fixture: any;
  let instance: any;
  beforeEach(async(() => TestUtils.beforeEachCompiler([PartnerProfile]).then(compiled => {
    fixture = compiled.fixture;
    instance = compiled.instance;
  })));
  it('should be able to load', async(() => {
    const partnerprofile = fixture.debugElement.componentInstance;
    expect(partnerprofile).toBeTruthy();
  }));
})
