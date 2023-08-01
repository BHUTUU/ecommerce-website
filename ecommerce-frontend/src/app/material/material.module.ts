import { NgModule } from '@angular/core';
import { MatInputModule } from '@angular/material/input';


const MaterialComponent = [
  MatInputModule
];
@NgModule({
  imports: [MaterialComponent],
  exports: [MaterialComponent]
})
export class MaterialModule { }
