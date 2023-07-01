import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'age'
})
export class AgePipe implements PipeTransform {

  transform(value: any, ...args: unknown[]): unknown {
    let currentYear = new Date().getFullYear(); //2023
    let birthYear = new Date(value).getFullYear();

    return currentYear - birthYear;
  }

}
