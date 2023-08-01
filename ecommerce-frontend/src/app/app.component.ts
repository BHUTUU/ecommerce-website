import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ecommerce-frontend';
  productName: string='';
  productBrand: string='';
  productCategory: string='';
  productQuantity: string='';
  productPrice: string='';
  productDescription: string='';

  constructor(private http: HttpClient) {}

  onSubmit() {
    const params = new URLSearchParams();
    params.append('productName', this.productName);
    params.append('productBrand', this.productBrand);
    params.append('productCategory', this.productCategory);
    params.append('productQuantity', this.productQuantity.toString()); // Convert number to string
    params.append('productPrice', this.productPrice.toString()); // Convert number to string
    params.append('productDescription', this.productDescription);
  
    this.http.post('http://localhost:8383/saveProduct?' + params.toString(), null)
      .subscribe(
        response => {
          console.log('Product added successfully:', response);
          alert('Product added successfully');
        },
        error => {
          console.error('Error adding product:', error);
          alert("Error adding product");
        }
      );
  }
  
}
