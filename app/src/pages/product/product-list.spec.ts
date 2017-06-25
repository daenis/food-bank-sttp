import { async } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';
import { environment } from '../../environments/environment';
import { ProductListComponent } from './product-list.component';
import { TestUtils } from '../../test';

describe('ProductListComponent', () => {
    let fixture: any;
    let instance: any;
    let button: DebugElement;
    beforeEach(async(() => TestUtils.beforeEachCompiler([ProductListComponent]).then(compiled => {
        fixture = compiled.fixture;
        instance = compiled.instance;
    })));

    it('should be able to load', () => {
        const productListComponent = fixture.debugElement.componentInstance;
        expect(productListComponent).toBeTruthy();
    });
    
})

	