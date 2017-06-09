/* tslint:disable */
import { Component } from '@angular/core';
import { HomePage } from './home';
import { NavController } from 'ionic-angular';
import { TestBed, ComponentFixture, async } from '@angular/core/testing';
import { IonicModule } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { MyApp } from '../../app/app.component';

let comp: HomePage;
let fixture: ComponentFixture<HomePage>;
 
describe('Component: Home Component', () => {
    beforeAll(async(() => {
        TestBed.configureTestingModule({
            declarations: [MyApp, HomePage],
            providers: [
                StatusBar,
                SplashScreen
            ],
            imports: [
                IonicModule.forRoot(MyApp)
            ]
        }).compileComponents();
    }));
 
    beforeAll(() => {
        fixture = TestBed.createComponent(HomePage);
        comp = fixture.componentInstance;
    });
 
    afterAll(() => {
        fixture.destroy();
        comp = null;
    });

    it('should have a dummy test', () => {
        expect(true).toBeTruthy();
    });

});


