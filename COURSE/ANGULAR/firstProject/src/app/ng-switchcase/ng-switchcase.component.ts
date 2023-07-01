import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-ng-switchcase',
  templateUrl: './ng-switchcase.component.html',
  styleUrls: ['./ng-switchcase.component.css']
})
export class NgSwitchcaseComponent {
  posts:any;


  constructor(private http:HttpClient){
    this.http.get("https://jsonplaceholder.typicode.com/posts").subscribe(res=>this.posts = res)  
  }


}
