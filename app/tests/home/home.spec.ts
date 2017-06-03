import { HomePage } from '../../src/pages/home/home';
//import { NavController } from 'ionic-angular';
import { async } from '@angular/core/testing';

describe('HomePage', function() {
    beforeEach(async(function() {
        TestBed.configureTestingModule({
            declarations: [ HomePage ], // declare the test component
        })
        .compileComponents();  // compile template and css
    }));

    beforeEach(function () {
        fixture = TestBed.createComponent(HomePage);

        comp = fixture.componentInstance; // BannerComponent test instance
    });

    it('Testing HomePage Load', function() {
    })
});
