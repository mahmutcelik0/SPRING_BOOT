import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-tech',
  templateUrl: './tech.component.html',
  styleUrls: ['./tech.component.css']
})
export class TechComponent {
  constructor(private route:ActivatedRoute){
    console.log(route);
    route.paramMap.subscribe(res =>{
      console.log("RESPONSE",res)
      console.log("RESPONSE",res.get('technology'))
    })
  }
}
