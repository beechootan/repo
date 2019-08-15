import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service'
// import { DocStatusService } from '../doctorstatus.service'




@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  
  public doctors:any = [];

  constructor(private docStatusService: DoctorService) { }

  ngOnInit() {
    // this.docStatusService.getDoctors().subscribe(response => {
    //   this.doctors = response as Doctor[]
    // })
    this.docStatusService.getDoctors()
      .subscribe(data => {
        
        this.doctors.push(data)
      });
     
  }

}
