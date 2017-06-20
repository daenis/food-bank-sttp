import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';
import { environment } from '../../environments/environment';
import { OrderForm } from './orderform';
import { Product } from '../product/product';

@Injectable()
export class OrderFormService {

		private _productUrl = environment.uri + 'api/order';
		constructor(private _http: Http) {}

		public removeFromOrder(referenceNumber: number) {
			return this._http.delete(this._productUrl, new RequestOptions({
				body: { referenceNumber }
			})).toPromise()
		}

		private handleError(error: Response) {
				console.error(error);
				return Observable.throw(error.json().error || 'Server error');
		}

		public getOrdersPromise(): Promise<any> {
			return new Promise(resolve => { 
				this._http.get(this._productUrl)
				.map((res => res.json()))
				.subscribe(data => {resolve(data.items)});
			})
		}
		

}
