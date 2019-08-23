import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http' ;
import { appointmentStatus, toCancel } from './appoitments';


@Injectable({
    providedIn: 'root'
  })

// http://localhost:8080/api/appointments/<nurseId>/<appointmentId>/checkIn

export class appointmentService {

    private _url : string ='http://localhost:8080/api/appointments';
    private baseUrl : string = 'http://localhost:8080/api/appointments';
    private baseUrl2 : string = 'http://localhost:8080/api/appointments/cancel';

    constructor(private http: HttpClient) { }

    getAppStatus(): Observable<appointmentStatus[]> {
        return this.http.get<appointmentStatus[]>(this._url);
       
      }

      checkInTime(nurseId: number, appointmentId: number){
    
    return this.http.post(`${this.baseUrl}/${nurseId}/${appointmentId}/checkIn`, {});
    // return this.http.post(`${this.baseUrl}/${nurseId}/${appointmentId}/checkIn`, {},{ responseType:'text', observe: 'response' } );
       }

       checkOutTime(nurseId: number, appointmentId: number){
    
        return this.http.post(`${this.baseUrl}/${nurseId}/${appointmentId}/checkOut`, {});
        // return this.http.post(`${this.baseUrl}/${nurseId}/${appointmentId}/checkIn`, {},{ responseType:'text', observe: 'response' } );
           }
      // checkInTime(checkInTime: checkInData){
   
        AddCancel(forCancel: toCancel){
          return this.http.post(this.baseUrl2, forCancel, {
            headers: new HttpHeaders({
              'Content-Type': 'application/json',
            }),
            responseType: "text"
          });
      
          }
        }
