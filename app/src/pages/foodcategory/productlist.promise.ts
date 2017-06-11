import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service.promise';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'product-promise',
  templateUrl: './foodcategory.html',
  providers: [ ProductService ],
  styles: ['.error {color:red;}']
})
export class ProductListPromise implements OnInit {
  errorMessage: string;
  products: Product[];
  mode = 'Promise';

  constructor (public navCtrl:NavController, private productService: ProductService) {}

  ngOnInit() { this.getProductsList(); }

  getProductsList() {
    this.productService.getProductsList()
                     .then(
                       products => this.products = products,
                       error =>  this.errorMessage = <any>error);
  }

}