import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-get-request-component',
  templateUrl: './get-request-component.component.html',
  styleUrls: ['./get-request-component.component.css']
})
export class GetRequestComponentComponent {

  users : any;
  constructor(private http : HttpClient){

  }
  ngOnInit(){
    this.http.get("https://jsonplaceholder.typicode.com/users").subscribe(res =>{
      this.users = res;
    });
  }

}
