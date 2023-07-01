import { Component } from '@angular/core';

@Component({
  selector: 'app-multiple-parameter-pipe',
  templateUrl: './multiple-parameter-pipe.component.html',
  styleUrls: ['./multiple-parameter-pipe.component.css']
})
export class MultipleParameterPipeComponent {
  users = [
    {"name":"MAHMUT CELIK",
      "firstScore":100,
      "secondScore":200,
      "thirdScore":300
    },
    {"name":"ELA CELIK",
      "firstScore":100,
      "secondScore":150,
      "thirdScore":300
    },
    {"name":"BESTE BOYBASI",
      "firstScore":100,
      "secondScore":120,
      "thirdScore":350
    },
    {"name":"MANGAN GOODMAN",
      "firstScore":100,
      "secondScore":200,
      "thirdScore":200
    },
  ]
}
