// Promise Version
import { Injectable }              from '@angular/core';
import { Http, Response }          from '@angular/http';


import 'rxjs/add/operator/toPromise';

import { Product } from './product';

@Injectable()
export class ProductService {

  private productsUrl = 'localhost:6700';

  constructor (private http: Http) {}

  getProductsList(): Promise<Product[]> {
    return this.http.get(this.productsUrl)
                    .toPromise()
                    .then(this.extractProductsList)
                    .catch(this.handleError);
  }

  private extractProductsList(res: Response) {
    let body = res.json();
    return body.productList.category || { };
  }

  private handleError (error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Promise.reject(errMsg);
  }

}
