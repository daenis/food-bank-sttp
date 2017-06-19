import { Component, OnInit } from '@angular/core';
import { NavController } from 'ionic-angular';
import { ProductService } from '../product/product.service';
import { Injectable } from '@angular/core';
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
    this.orderFormService.getOrders()
      .subscribe(products => this.products = products,
      error => this.errorMessage = <any>error);
    // PROMISE VERSION                    
    // this.OrderFormService.getOrdersPromise()
    //   .then(products => this.products = products,
    //   error => this.errorMessage = <any>error)
    //   .then(() => {
    //     console.log(this.products)
    //     this.getOrderTotal()
    //   })              
  }

  // public ionViewDidLoad() {
  //   this.getOrderTotal();
  // }

  // public getOrderTotal(): number {
  //   this.productsTotal = 0;
  //   let products = this.products["items"];
  //   for (var i = 0; i < this.products.length; i++) {
  //     this.productsTotal += products[i].price;
  //   }
  //   return this.productsTotal;

  // }

  // Remove product from cart
  public delete(product : Product): void {
		this.orderFormService
    .delete(product.referenceNumber)
    .then(() => {
      this.products = this.products.filter(p => p !== product)
    })
	}

  public goBack() {
    this.navController.pop();
  }

}
