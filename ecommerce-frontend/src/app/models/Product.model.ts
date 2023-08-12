import { FileHandle } from "./file-handle.model";

export interface Product {
    productName: string;
    productBrand: string;
    productCategory: string;
    productQuantity: number;
    productActualPrice: number;
    productDiscountedPrice: number;
    productDescription: string;
    productImage: FileHandle[];
}