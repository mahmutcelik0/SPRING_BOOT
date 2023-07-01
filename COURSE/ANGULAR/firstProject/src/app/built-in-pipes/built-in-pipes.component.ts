import { Component } from '@angular/core';

@Component({
  selector: 'app-built-in-pipes',
  templateUrl: './built-in-pipes.component.html',
  styleUrls: ['./built-in-pipes.component.css']
})
export class BuiltInPipesComponent {
  firstName:string = "MAHMUT";
  lastName:string = "CELIK";
  school: string = "egeUNIVERSITY";
  money:number = 100;
  jsonValue:any = {"aa":"bb","cc":"cc"};
}
