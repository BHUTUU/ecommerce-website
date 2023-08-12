import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductAddFormComponent } from './product-add-form/product-add-form.component';
import { ProductShowTableComponent } from './product-show-table/product-show-table.component';

const routes: Routes = [
  {
    path: 'addProducts',
    component: ProductAddFormComponent
  },
  {
    path: 'showProduct',
    component: ProductShowTableComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
