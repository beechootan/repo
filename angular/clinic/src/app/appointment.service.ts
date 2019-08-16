import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http' ;
import { appointmentStatus } from './appoitments';


@Injectable({
    providedIn: 'root'
  })



export class appointmentService {

    private _url : string ='http://localhost:8080/api/appointments';

    constructor(private http: HttpClient) { }

    getAppStatus(): Observable<appointmentStatus[]> {
        return this.http.get<appointmentStatus[]>(this._url);
       
      }
}