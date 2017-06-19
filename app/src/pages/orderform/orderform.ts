import { Component } from '@angular/core';
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

@Component({
  selector: 'page-orderform',
  templateUrl: 'orderform.html',
  providers: [ProductService]
})
export class OrderForm {

  constructor(public navController: NavController) {

  }
  
	public goBack() {
		this.navController.pop();
	}

}
