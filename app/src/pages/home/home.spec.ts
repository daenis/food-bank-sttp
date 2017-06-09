import { TestBed, async } from '@angular/core/testing';
import { NavController, IonicModule } from 'ionic-angular';
import { HomePage } from './home';
import { TestUtils } from '../../test';

describe('HomePage', () => {
  let fixture: any;
  let instance: any;
  beforeEach(async(() => TestUtils.beforeEachCompiler([HomePage]).then(compiled => {
    fixture = compiled.fixture;
    instance = compiled.instance;
  })));
  it('should create the app', async(() => {
    const home = fixture.debugElement.componentInstance;
    expect(home).toBeTruthy();
  }));
})
