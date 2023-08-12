import { Component } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
// import { Product } from '../models/Product.model';
import { FormGroup, NgForm } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
// import { FileHandle } from '../models/file-handle.model';
import { DomSanitizer } from '@angular/platform-browser';
import { Product } from 'src/app/models/Product.model';
import { FileHandle } from 'src/app/models/file-handle.model';

@Component({
  selector: 'app-product-add-form',
  templateUrl: './product-add-form.component.html',
  styleUrls: ['./product-add-form.component.css']
})
export class ProductAddFormComponent {
  title = 'ecommerce-frontend';
  product: Product = {
    productName: "",
    productBrand: "",
    productCategory: "",
    productQuantity: 0,
    productActualPrice: 0,
    productDiscountedPrice: 0,
    productDescription: "",
    productImage: []
  }

  constructor(private http: HttpClient, private snackBar: MatSnackBar, private sanitizer: DomSanitizer) {}
  productForm!: FormGroup;
  prepareFormData(product: Product):FormData{
    const formData=new FormData();
    
      formData.append('product',
      new Blob([JSON.stringify(product)], {type:'application/json'}));
      for(var i=0; i< product.productImage.length;i++)
  {
  formData.append('imageFile',product.productImage[i].file,
  product.productImage[i].file.name);
  }
    return formData;
    
  }
  OnFileSelected(event:any) {
    if(event.target.files){
      const file=event.target.files[0];
   const fileHandle:FileHandle={
    file:file,
url: this.sanitizer.bypassSecurityTrustResourceUrl(
  window.URL.createObjectURL(file)
)
   }
   this.product.productImage.push(fileHandle);
    }
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
