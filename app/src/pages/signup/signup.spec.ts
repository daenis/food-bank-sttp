import { async } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';
import { environment } from '../../environments/environment';
import { SignUp } from './signup';
import { TestUtils } from '../../test';

describe('SignUp', () => {
	let fixture: any;
	let instance: any;
	let button: DebugElement;
	beforeEach(async(() => TestUtils.beforeEachCompiler([SignUp]).then(compiled => {
		fixture = compiled.fixture;
		instance = compiled.instance;
		button = fixture.debugElement.query(By.css('.sign-up'))
	})));

	it('should be able to load', () => {
		const volunteersignup = fixture.debugElement.componentInstance;
		expect(volunteersignup).toBeTruthy();
	});

	it('Check empty form submission ', () => {
		button.triggerEventHandler('ngSubmit', {})
		fetch(environment.uri + 'data/users')
		.then(response => response.json())
		.then((json: Array<Object>) => expect(json.length).toBe(4));
	});

	it ('Added form', () => {
		const form: DebugElement[] = fixture.debugElement.queryAll(By.css('input'))
		form.map(e => e.nativeElement.value = 'dummy data')
		button.triggerEventHandler('ngSubmit', null)
		setTimeout(() =>  {
			fetch(environment.uri + 'data/users')
			.then(response => response.json())
			.then((json: Array<Object>) => {
				expect(json.length).toBe(5)
			});
		}, 5000);
	})
})
