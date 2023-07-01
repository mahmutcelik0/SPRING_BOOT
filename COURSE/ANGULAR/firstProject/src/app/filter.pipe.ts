import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {
  transform(users: any[], filterValue: any): any {
    if(filterValue ==="" || filterValue ===undefined || filterValue === false){
      return users;
    }

    const returnValue:any = [];

    users.forEach(e =>{
      if(e["city"].toLowerCase().startsWith(filterValue.toLowerCase()))returnValue.push(e);
    })

    return returnValue;
  }
}
