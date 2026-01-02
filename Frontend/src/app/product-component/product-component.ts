import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../service';
import { Product } from './products';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-component.html',
  styleUrls: ['./product-component.css']
})


export class ProductsComponent implements OnInit {

  products: Product[] = [];

  constructor(private service: Service, private router: Router) {}
  

  ngOnInit(): void {
    this.service.getProducts().subscribe({
      next: (data: Product[]) => {
        this.products = data;
        
      },
      error: (err: any) => {
        console.error('Error fetching products:', err);
      }
    });
  }
}
