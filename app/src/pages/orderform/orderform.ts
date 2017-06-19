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
  providers:[OrderFormService]
})
export class OrderForm implements OnInit {
  	private errorMessage: string;
		private products: Product[];
    private productsTotal: number;

	  constructor(private http: Http,
    private navController: NavController,
    private OrderFormService: OrderFormService) {}

		public ngOnInit(): void {
				// this.OrderFormService.getOrders()
				// 				.subscribe(products => this.products = products,
				// 										error => this.errorMessage = <any> error);
        this.OrderFormService.getOrdersPromise()
        .then(products => this.products = products,
        error => this.errorMessage = <any> error)
        .then(() => {
          console.log(this.products)
          this.getOrderTotal()
        })              
		}

    public ionViewDidLoad() {
      this.getOrderTotal();
    }

    public getOrderTotal() {
      this.productsTotal = 0;
      var products = this.products["items"];
      for (var i = 0; i < this.products.length; i++) {
        this.productsTotal += products[i].price;
      }

    }

	  public goBack() {
		  this.navController.pop();
	  }

}
