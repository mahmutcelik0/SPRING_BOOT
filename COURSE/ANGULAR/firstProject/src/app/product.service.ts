import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  getProducts(){
    return [
      {
        "id":1,
        "name":"MAHMUT",
        "surname":"CELIK",
        "number":123
      },
      {
        "id":2,
        "name":"ELA",
        "surname":"CELIK",
        "number":345
      },
      {
        "id":3,
        "name":"BESTE",
        "surname":"BOYBASI",
        "number":456
      },
      {
        "id":4,
        "name":"MANGAN",
        "surname":"GOODMAN",
        "number":567
      },
      {
        "id":5,
        "name":"NILAY",
        "surname":"CATLI",
        "number":678
      }
    ];
  }



  constructor() { }
}
