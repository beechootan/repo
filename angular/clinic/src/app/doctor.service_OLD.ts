import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { BehaviorSubject } from 'rxjs';

// const baseUrl = 'http://localhost:8080/api/doctorStatus'

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
    private doctors: BehaviorSubject<any> = new BehaviorSubject([])
    
  constructor(private http: HttpClient) { 

  this.getDoctors().subscribe(response => {
    this.doctors.next(response)
  })
}
getDoctors(){
    return this.http.get('http://localhost:8080/api/doctorStatus', {responseType: "text"})
  }
 
}
