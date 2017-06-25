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
        button = fixture.debugElement.query(By.css('.pick-up'))
    })));

    it('should be able to load', () => {
        const productListComponent = fixture.debugElement.componentInstance;
        expect(productListComponent).toBeTruthy();
    });

	it('should have empty fields', () => {
		fetch(environment.uri + 'api/order')
		.then(response => response.json())
		.then((json: Array<Object>) => expect(json.length).toBeUndefined());
	});
    
})

	