import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product-component/products';


@Injectable({
  providedIn: 'root',
})
export class Service {

  constructor(private http:HttpClient){

  }
  onSignUp(signUpDetails:any):Observable<any>{
    return this.http.post('http://localhost:8080/api/users/save-all',signUpDetails);
  }

  loginUser(loginDetails:any):Observable<any>{
    return this.http.post('http://localhost:8080/api/users/login',loginDetails);
  }
  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('http://localhost:8080/api/products/getAll');
  }

 
 
}
  

