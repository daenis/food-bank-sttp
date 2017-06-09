import { TestBed, async } from '@angular/core/testing';
import { NavController, IonicModule } from 'ionic-angular';
import { VolunteerSignUp } from './volunteersignup';
import { TestUtils } from '../../test';

describe('VolunteerSignUp', () => {
  let fixture: any;
  let instance: any;
  beforeEach(async(() => TestUtils.beforeEachCompiler([VolunteerSignUp]).then(compiled => {
    fixture = compiled.fixture;
    instance = compiled.instance;
  })));
  it('should be able to load', async(() => {
    const volunteersignup = fixture.debugElement.componentInstance;
    expect(volunteersignup).toBeTruthy();
  }));
})
