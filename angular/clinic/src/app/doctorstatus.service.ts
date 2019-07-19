import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from 'selenium-webdriver/http';


@Injectable({
  providedIn: 'root'
})
export class DoctorstatusService {

  private doctor: BehaviorSubject<any> = new BehaviorSubject([])

  constructor(private http: HttpClient) {
  
  this.getDocStatus().subscribe(response => {
  this.doctor.next(response)
  })
  } 

  getDocStatus() {
    return this.http.get('http://localhost:8080/api/doctorStatus')
  }

}
