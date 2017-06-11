import { Component, OnInit } from '@angular/core';
import { Product }              from './product';
import { ProductService }       from './product.service';

@Component({
  selector: 'product-list',
  templateUrl: './foodcategory.html',
  providers: [ ProductService ],
  styles: ['.error {color:red;}']
})
export class ProductListComponent implements OnInit {
  errorMessage: string;
  products: Product[];

  constructor (private productService: ProductService) {}

  ngOnInit() { this.getProducts(); }

  getProducts() {
    this.productService.getProducts()
                     .subscribe(
                       products => this.products = products,
                       error =>  this.errorMessage = <any>error);
  }
  
}
