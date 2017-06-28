import { Component, OnInit, OnChanges } from '@angular/core';
import { NavController } from 'ionic-angular';
import { ProductService } from '../product/product.service';
import { Injectable, ChangeDetectorRef } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';
import { environment } from '../../environments/environment';
import { Product } from '../product/product';
import { OrderFormService } from './orderform.service';
import { Auth } from '../../app/auth.service';

@Component({
  selector: 'page-orderform',
  templateUrl: 'orderform.html',
  providers: [OrderFormService, Auth]
})
export class OrderForm implements OnInit {
  private errorMessage: string;
  private products: Product[];
  private productsTotal: number;
  private users: String[];

  constructor(private http: Http,
    private navController: NavController,
    private orderFormService: OrderFormService,
    private auth: Auth) { }

  public ngOnInit(): void {
    this.orderFormService.getOrdersPromise()
      .then(products => this.updateProduct(products),
      error => this.errorMessage = <any> error)
  }
  // Refreshes the Product array -- makes it so that when a pick-up
  // is deleted, the page UI updates
  private updateProduct(data: Product[]) {
    this.products = data
  }
  // Removes the posted pick-up request
  public deletePickUpRequest(category: string) {
    this.orderFormService.removeFromPickUpBoard(category)
                            .then(e => this.orderFormService.getOrdersPromise())
                            .then(products => this.updateProduct(products))
  }

  public goBack() {
    this.navController.pop();
  }

  public isUserAFarmRep(): boolean {
    console.log(this.auth.getUserType());
    if (this.auth.getUserType() === "farmrep") {
      return true;
    } else {
      return false;
    }
  }

  private getUsers(): void {
      this.getUsersObservable().subscribe(users => this.users = users, error => this.errorMessage = <any> error);
  }

  private getUsersObservable(): Observable<String[]> {
				return this.http.get("http://localhost:8100/data/users")
						.map((response: Response) => <String[]> response.json()["users"])
            .catch(this.handleError);
	}

  private handleError(error: Response) {
				console.error(error);
				return Observable.throw(error.json().error || 'Server error');
		}

}
