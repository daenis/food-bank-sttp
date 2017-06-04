import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { ProductForm } from '../productform/productform';

@Component({
  selector: 'page-volunteer',
  templateUrl: 'volunteer.html'
})
export class Volunteer {

    private firstName = document.getElementById("FirstName");
    private lastName = document.getElementById("LastName");
    private phoneNumber = document.getElementById("Phone#");
    private emailAddress = document.getElementById("VolunteerEmail");
    private address = document.getElementById("VolunteerAddress");
    constructor() {}

}   