import { Component } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-component',
  templateUrl: './product-component.component.html',
  styleUrls: ['./product-component.component.css']
})
export class ProductComponentComponent {
  products :any;
  productService;

  constructor(productService : ProductService){
    this.productService = productService;
  }

  ngOnInit(){
    this.products = this.productService.getProducts();
  }
}