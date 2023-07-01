import { Component } from '@angular/core';

@Component({
  selector: 'app-parameterized-pipe',
  templateUrl: './parameterized-pipe.component.html',
  styleUrls: ['./parameterized-pipe.component.css']
})
export class ParameterizedPipeComponent {

  filterValue:any ;
  users=[
    {"firstName":"MAHMUT",
      "lastName":"CELIK",
      "city":"IZMIR"
    },
    {"firstName":"ELA",
      "lastName":"CELIK",
      "city":"DENIZLI"
    },
    {"firstName":"BESTE",
      "lastName":"BOYBASI",
      "city":"ISTANBUL"
    },
    {"firstName":"NILAY",
      "lastName":"CATLI",
      "city":"ISTANBUL"
    },
    {"firstName":"MANGAN",
      "lastName":"GOODMAN",
      "city":"ISTANBUL"
    },
    {"firstName":"OZGUR",
      "lastName":"BAYRASA",
      "city":"ANTALYA"
    },
    {"firstName":"LAL",
      "lastName":"ARSLAN",
      "city":"ANKARA"
    }
  ];
}