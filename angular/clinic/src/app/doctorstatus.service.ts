import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http' ;
import { checkDoctorStatus } from './doctorstatus';
import { postData } from './appoitments';



@Injectable({
  providedIn: 'root'
})
export class DoctorstatusService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  }


  private _url : string ='http://localhost:8080/api/doctorStatus';
  private totalQueueUrl : string ='http://localhost:8080/api/appointments/currentQueue';
  private baseUrl : string ='http://localhost:8080/api/appointments';
  private baseUrl2 : string ='http://localhost:8080/api/appointments/addAppointment';
  private cNurse: string ='http://localhost:8080/api/employee'
  
  constructor(private http: HttpClient) { 
  
  }

  //   this.getDocStatus().subscribe(response => {
  //   this.doctor.next(response)
  //   })
  // } 

  // getDocStatus(): Observable<checkDoctorStatus[]> {
  //   return this.http.get<checkDoctorStatus[]>(this._url);  
   
  // }


  getDocStatus(){
    return this.http.get(this._url, {responseType: "text"} );
    
  }

  getCurrentQueuenumber(){
    return this.http.get(this.totalQueueUrl, {responseType: "text"} );
  }

  getOwnQueueNo(employeeId: number){
    return this.http.get(`${this.baseUrl}/${employeeId}/today`, {responseType: "text"} );
  }

  getNurse(employeeId: number){
    return this.http.get(`${this.cNurse}/${employeeId}`, {responseType: "text"} );
  }

  // AddReserve(employeeId: number, patientId: number){
    
  //   return this.http.post(`${this.baseUrl}/${employeeId}/${patientId}/addAppointment`, {},{ responseType:'text', observe: 'response' } );
    

// }


  AddReserve(addAppoint: postData){
   
  // const url = `${this.baseUrl}/${employeeId}/${patientId}/addAppointment`
  // return this.http.post(`${this.baseUrl}/${employeeId}/${patientId}/addAppointment` );
  // return this.http.post(this.baseUrl,employeeId,patientId );
  // return this.http.post(url,employeeId,patientId,httpOption)
    return this.http.post(this.baseUrl2, addAppoint, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      responseType: "text"
    });


  }
}
