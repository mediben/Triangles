import { Component, OnInit } from '@angular/core';
import { TypesService } from '../services/types.service';

@Component({
  selector: 'app-trianglestype',
  templateUrl: './trianglestype.component.html',
  styleUrls: ['./trianglestype.component.css'],
  providers: [TypesService]
})
export class TrianglestypeComponent implements OnInit {
  isosceles  = false;
  equilateral = false;
  scalene = false;
  equilateralActu = false;
  popup = false;

  type: string;
  sideA: string;
  sideB: string;
  sideC: string;

  constructor(private triangleservice: TypesService) { }

  ngOnInit() {}

  save() {
    if (this.type != null) {
      let params = {'pointA': this.sideA, 'pointB': this.sideB, 'pointC': this.sideC, 'type': this.type};
      this.triangleservice.addTriangle(params).subscribe((res) => {
        this.popup = true;
        setTimeout(function () {
            this.popup = false;
          }.bind(this), 2500);
      });
    } else {
      console.log('Add sides length first !');
    }
  }


  getType() {
    let params = {'pointA': this.sideA, 'pointB': this.sideB, 'pointC': this.sideC};

    this.triangleservice.getTriangleType(params).subscribe((res) => {

      switch (res) {
        case 'Isosceles':
          this.isosceles = true;
          this.equilateral = false;
          this.scalene = false;
          this.type = 'Isosceles';
          break;

        case 'Equilateral':
          this.isosceles = false;
          this.equilateral = true;
          this.scalene = false;
          this.type = 'Equilateral';
          break;

        case 'Scalene':
        console.log('==> 3');
          this.isosceles = false;
          this.equilateral = false;
          this.scalene = true;
          this.type = 'Scalene';
          break;

        default:
          break;
      }
    });
  }
}
