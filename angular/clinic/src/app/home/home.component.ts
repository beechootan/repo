import { Component, OnInit } from '@angular/core';
// import { DoctorService } from '../doctor.service'
import { DoctorstatusService } from '../doctorstatus.service';

// import { DocStatusService } from '../doctorstatus.service'




@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  
  public doctors:any = [];
  doctorStatus: string = null;

  // constructor(private docStatusService: DoctorService) { }
  constructor(private docStatusService: DoctorstatusService) { }

  ngOnInit() {
    // this.docStatusService.getDoctors().subscribe(response => {
    //   this.doctors = response as Doctor[]
    // })
    // this.docStatusService.getDoctors()
    //   .subscribe(data => {
        
    //     this.doctors.push(data)
    //   });

    this.docStatusService.getDocStatus()
    .subscribe(data => {
      this.doctorStatus = data as string
    });
     
  }

}
