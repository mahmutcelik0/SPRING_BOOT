import { Component } from '@angular/core';

@Component({
  selector: 'app-custom-pipe',
  templateUrl: './custom-pipe.component.html',
  styleUrls: ['./custom-pipe.component.css']
})
export class CustomPipeComponent {
  users = [
    {
      "firstName": "MAHMUT",
      "lastName": "CELIK",
      "dateOfBirth":"2001-10-19",
      "phoneNumber":123123123
    },
    {
      "firstName": "ELA",
      "lastName": "CELIK",
      "dateOfBirth":"2013-10-19",
      "phoneNumber":123123123
    },
    {
      "firstName": "BESTE",
      "lastName": "BOYBASI",
      "dateOfBirth":"2000-10-19",
      "phoneNumber":123123123
    },
    {
      "firstName": "MANGAN",
      "lastName": "GOODMAN",
      "dateOfBirth":"1950-10-19",
      "phoneNumber":123123123
    }
  ]
}
