import { Component } from '@angular/core';

@Component({
  selector: 'app-ng-for-example',
  templateUrl: './ng-for-example.component.html',
  styleUrls: ['./ng-for-example.component.css']
})
export class NgForExampleComponent {
  products : any;

  constructor(){
    console.log("ENTERED")
    this.products = [
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
    ]
  }
}