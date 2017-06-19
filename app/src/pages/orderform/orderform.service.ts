import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
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

		public getOrders(): Observable<Product[]> {
			return this._http.get(this._productUrl)
				.map((response: Response) => <Product[]>response.json()["items"])
				.catch(this.handleError);
		}

		public delete(referenceNumber: number): Observable<Product[]> {
			return this._http.delete(this._productUrl, referenceNumber)
			.map((response: Response) => response.json())
			.catch(this.handleError);
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
