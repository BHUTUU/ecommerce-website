import { Component } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Product } from './models/Product.model';
import { FormGroup, NgForm } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ecommerce-frontend';
  product: Product = {
    productName: "",
    productBrand: "",
    productCategory: "",
    productQuantity: "",
    productPrice: "",
    productDescription: ""
  }

  constructor(private http: HttpClient, private snackBar: MatSnackBar) {}
  productForm!: FormGroup;
  prepareFormData(product: Product):FormData{
    const formData=new FormData();
    
      formData.append('product',
      new Blob([JSON.stringify(product)], {type:'application/json'}));
    return formData;
    
  }
  onSubmit(productForm:NgForm) {
    const postData=this.prepareFormData(this.product);
  //console.log(this.leaseagreementdetails)
      //const formData = this.toFormData(this.leaseagreementdetailsForm.value);
      //formData.append('file', this.photos[0], this.photos[0].name);
      //const formdata=this.leaseagreementdetailsForm.value;
      this.addLeaseDetails(postData).subscribe({
        next: (response: Product) => console.log(response),
        error: (error: HttpErrorResponse) => console.error(error),
        complete: () => this['snackBar'].open('ProductDetails Added Successfully', 'Ok', {
          duration: 5000
        
        })
      })
    }
    public addLeaseDetails(product:FormData)
    {
      return this.http.post<Product>('http://localhost:8383/saveProduct',product)
    }  
}
