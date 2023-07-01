import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  getUser(){
    return this.http.get("http://localhost:8080/api/v1/product");
  }

  getProduct(){
    return this.http.get("http://localhost:8080/api/v1/product");
  }
}
