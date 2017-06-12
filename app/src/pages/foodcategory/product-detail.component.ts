import { Component } from '@angular/core';

import { Product } from './product';

@Component({
		templateUrl: './product-detail.component.html'
})
export class ProductDetailComponent {
		public pageTitle: string = 'Product Detail';
		public product: Product;
}
