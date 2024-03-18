import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'prod-comp',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent {
  constructor(private router: Router) {}
  products = [
    { id: 101, name: 'laptop', price: 3200 },
    { id: 102, name: 'phone', price: 3200 },
    { id: 103, name: 'TV', price: 3200 },
  ];

  onselectname(p: any) {
    this.router.navigate(['/selectedprod', p.name]);
  }
}
