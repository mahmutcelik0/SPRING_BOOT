import { Component } from '@angular/core';
import { User } from './user';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent {
  user:User = {
     "id":123,
     "name":"MAHMUT",
     "email":"CELIK",
     "mobile":444
  }
}
