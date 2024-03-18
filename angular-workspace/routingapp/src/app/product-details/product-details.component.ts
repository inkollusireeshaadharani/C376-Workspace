import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css'],
})
export class ProductDetailsComponent {
  constructor(private ar: ActivatedRoute) {
    let name = this.ar.snapshot.params['nam'];
    this.prod_nam = name;
  }
  prod_nam = '';
}
