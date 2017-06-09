import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';


@Component({
  selector: 'page-foodcategory',
  templateUrl: 'foodcategory.html'
})

export class FoodCategory {

    searchQuery: string = '';

    items: ReadonlyArray<string>;

    constructor(public navCtrl:NavController){
        this.initializeItems()
		}

    initializeItems(){
        this.items = Object.freeze([
            'Assorted Frozen Product by the Pound',
            'Non Food Items by the Case',
            'Bread and Grains by the Case',
            'Beverages by the Case',
            'Dairy by the Pound',
            'Dairy by the Case',
            'Snacks and Deserts by the Case',
            'Juice by the Case',
            'Meat by the Case',
            'Meat by the Pound',
            'Misc. Meal Boxes',
            'Meals and Entrees by the Case',
            'Non Meat Proteins by the Case',
            'Fresh Produce by the Pound',
            'Sauces and Condiments by the Case',
            'Soup by the Case',
            'Vegtables by the Case',
            'USDA Food Items (limited to 10) by the Case',
            'USDA (unlimited) by the Case'
        ]);
    }

    getItems(ev: any){
        this.initializeItems();

        let val = ev.target.value;

        if(val && val.trim() != ''){
            this.items = this.items.filter((item) => {
                return (item.toLowerCase().indexOf(val.toLowerCase()) > -1);
            })
        }
    }

    

}
