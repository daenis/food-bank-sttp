import { Component, OnInit } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { Product } from './product';
import { ProductService } from './product.service';
import { ProductDetailComponent } from './product-detail.component';

@Component({
		templateUrl: './product-list.component.html',
		providers: [ProductService]
})
export class ProductListComponent implements OnInit {
		public pageTitle: string = 'Categories';
		public listFilter: string;
		public errorMessage: string;
		public products: Product[];

		constructor(
			private _productService: ProductService,
			private navCtrl: NavController,
			private navParams: NavParams) {
		}
		public ngOnInit(): void {
				this._productService.getProducts()
								.subscribe(products => this.products = products,
														error => this.errorMessage = <any> error);
		}
		public goToProductDetail(description) {
			this.navCtrl.push(ProductDetailComponent, description);
		}


}
