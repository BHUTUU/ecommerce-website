import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Product } from 'src/app/models/Product.model';
@Component({
  selector: 'app-product-show-table',
  templateUrl: './product-show-table.component.html',
  styleUrls: ['./product-show-table.component.css']
})
export class ProductShowTableComponent {

  productDetails: Product[] = [];
  displayedColumns: string[] = ['Id', 'Product Name', 'Product Brand', 'Product Actual Price', 'Product Discounted Price', 'Product Category', 'Product Quantity', 'Product Description'];
  constructor(private http: HttpClient) {

  }
  ngOnInit(): void {
    this.getAllProducts();
  }
  public getAllProducts() {
    this.getProductDetails().subscribe(
      (resp: Product[]) => {
        console.log(resp);
        this.productDetails = resp;
      }, (error: HttpErrorResponse) => {
        console.log(error);
      }
    );
  }
  public getProductDetails()
  {
    return this.http.get<Product[]>('http://localhost:8383/getAllProducts')
  }
}

