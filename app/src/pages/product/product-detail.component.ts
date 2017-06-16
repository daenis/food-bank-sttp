import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';
import { NavController } from 'ionic-angular';

@Component({
		templateUrl: './product-detail.component.html',
		providers: [ProductService]
})
export class ProductDetailComponent implements OnInit {
		public errorMessage: string;
		public products: String[];
		constructor(
			private _productService: ProductService) {
		}
		public ngOnInit(): void {
				this._productService.getProducts()
								.subscribe(products => this.products = products,
														error => this.errorMessage = <any> error);
		}
}
