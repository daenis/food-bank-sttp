import { Component, OnInit } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { Product } from './product';
import { ProductService } from './product.service';
//import { ProductDetailComponent } from './product-detail.component';
import { FoodItem } from '../fooditem/fooditem'

@Component({
		templateUrl: './product-list.component.html',
		providers: [ProductService]
})
export class ProductListComponent implements OnInit {
		private pageTitle: string = 'Categories';
		private errorMessage: string;
		private products: String[];

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
		public goToProductDetail(category: string) {
			console.log(category)
			this.navCtrl.push(FoodItem, {category});
		}

}
