import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/environment';
import { OrderForm } from './orderform';
import { Product } from '../product/product';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';


@Injectable()
export class OrderFormService {

	private _productUrl = environment.uri + 'api/order';
	constructor(private _http: Http) { }

	public removeFromPickUpBoard(category: string) {
		return this._http.delete(this._productUrl, new RequestOptions({
			body: { category }
		})).toPromise()
	}

	public deleteOrder(category: string) {
		return this._http.delete(this._productUrl, category)
		.catch(this.handleError);
	}

	public getOrdersPromise(): Promise<any> {
		return new Promise(resolve => {
			this._http.get(this._productUrl)
				.map((res => res.json()))
				.subscribe(data => { resolve(data.items) });
		})
	}

	public getOrders(): Observable<String[]> {
		return this._http.get(this._productUrl)
			.map((response: Response) => <String[]>response.json())
			.catch(this.handleError);
	}
	
	private handleError(error: Response) {
		console.error(error);
		return Observable.throw(error.json().error || 'Server error');
	}


}
