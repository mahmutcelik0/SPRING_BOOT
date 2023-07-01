import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'total'
})
export class TotalPipe implements PipeTransform {
  transform(value: any, secondScore: any,thirdScore:any): any {
    return value+secondScore*2+thirdScore*3;
  }
}
