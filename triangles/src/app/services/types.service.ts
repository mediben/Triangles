import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';

@Injectable()
export class TypesService {
  private header: Headers;
  apiURL = 'http://localhost:8080/TrianglesBackEnd/api/triangles/';

  constructor(private http: Http) { }


  gettest(): Observable<String> {
    const requette = this.http.get(this.apiURL + 'ping/', { headers: this.getHeaders() }).map(res => res.text()).map((res) => {
        return res;
    });
    return requette;
  }


  getTriangleType(dataInput): Observable<String> {
    return this.http.post(this.apiURL + 'typeside/', JSON.stringify(dataInput),
          { headers: this.getHeaders() }).map(res => res.text()).map((res) => {
            return res;
          });
  }


  addTriangle(dataInput): Observable<String> {
    return this.http.post(this.apiURL + 'add/', JSON.stringify(dataInput),
          { headers: this.getHeaders() }).map(res =>  {
           return res.text();
          });
  }



  private getHeaders() {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json; charset=utf-8');
    return headers;
  }
}
