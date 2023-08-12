import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductShowTableComponent } from './product-show-table.component';

describe('ProductShowTableComponent', () => {
  let component: ProductShowTableComponent;
  let fixture: ComponentFixture<ProductShowTableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProductShowTableComponent]
    });
    fixture = TestBed.createComponent(ProductShowTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
