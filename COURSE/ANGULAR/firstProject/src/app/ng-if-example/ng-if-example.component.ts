import { Component } from '@angular/core';

@Component({
  selector: 'app-ng-if-example',
  templateUrl: './ng-if-example.component.html',
  styleUrls: ['./ng-if-example.component.css']
})
export class NgIfExampleComponent {
  emptyProducts : any;

  constructor(){
    this.emptyProducts = [];
  }

}
