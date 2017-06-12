import { Component, OnInit } from '@angular/core';

import { Product } from './product';
import { ProductService } from './product.service';

@Component({
    templateUrl: './product-list.component.html',
    providers: [ProductService]
})
export class ProductListComponent implements OnInit {
    pageTitle: string = 'Product List';
    listFilter: string;
    errorMessage: string;

    products: Product[];

    constructor(private _productService: ProductService) {

    }

    ngOnInit(): void {
        this._productService.getProducts()
                .subscribe(products => this.products = products,
                           error => this.errorMessage = <any>error);
    }
    
}
