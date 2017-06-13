import { PipeTransform, Pipe } from '@angular/core';

import { Product } from './product';
import * as _ from 'lodash';

@Pipe({
		name: 'productDetailFilter'
})
export class ProductDetailPipe implements PipeTransform {
		public transform(value: any): any {
				if (value !== undefined && value !== null) {
						return _.uniqBy(value, 'description');
								}
						return value;
		}
}
