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
      .then(() => {
        console.log(this.products)
        this.getOrderTotal()
      })              
  }

  private updateProduct(data: Product[]) {
    this.products = data
  }

  public getOrderTotal(): number {
    this.productsTotal = 0;
    let products = this.products;
    for (var i = 0; i < this.products.length; i++) {
      this.productsTotal += products[i].price;
    }
    return this.productsTotal;
  }
  // Remove product from cart
  public deleteFromOrder(referenceNumber: number) {
    this.orderFormService.removeFromOrder(referenceNumber)
                            .then(e => this.orderFormService.getOrdersPromise())
                            .then(products => this.updateProduct(products))
                            .then(e => this.getOrderTotal())
  }

  public goBack() {
    this.navController.pop();
  }

}
