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

}
