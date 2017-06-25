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

@Component({
  selector: 'page-orderform',
  templateUrl: 'orderform.html',
  providers: [OrderFormService]
})
export class OrderForm implements OnInit {
  private errorMessage: string;
  private products: Product[];
  private productsTotal: number;

  constructor(private http: Http,
    private navController: NavController,
    private orderFormService: OrderFormService) { }

  public ngOnInit(): void {
    this.orderFormService.getOrdersPromise()
      .then(products => this.updateProduct(products),
      error => this.errorMessage = <any>error)   
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

}
