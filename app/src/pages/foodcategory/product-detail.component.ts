import { Component } from '@angular/core';

import { Product } from './product';

@Component({
    templateUrl: './product-detail.component.html'
})
export class ProductDetailComponent {
    pageTitle: string = 'Product Detail';
    product: Product;
}
