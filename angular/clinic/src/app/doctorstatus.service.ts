import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http' ;
import { checkDoctorStatus } from './doctorstatus';



@Injectable({
  providedIn: 'root'
})
export class DoctorstatusService {

  // private doctor: BehaviorSubject<any> = new BehaviorSubject([])
  private _url : string ='http://localhost:8080/api/doctorStatus';
  private totalQueueUrl : string ='http://localhost:8080/api/appointments/totalQueue';
  private baseUrl : string ='http://localhost:8080/api/appointments';
  
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

  AddReserve(employeeId: number, patientId: number){
    
    return this.http.post(`${this.baseUrl}/${employeeId}/${patientId}/addAppointment`, {},{ responseType:'text', observe: 'response' } );
    

}
}
