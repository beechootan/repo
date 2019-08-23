import { Component, OnInit } from '@angular/core';
// import { DoctorService } from '../doctor.service'
import { DoctorstatusService } from '../doctorstatus.service';
import { ActivatedRoute } from '@angular/router';
import { postData } from '../appoitments';


// import { DocStatusService } from '../doctorstatus.service'




@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  employeeId: number
  patientId: string
  public doctors:any = [];
  doctorStatus: string = null;
  empQueueNo: string = null;
  totalQueue: string = null;
  addDocAppointment: postData;
  data: string

  // constructor(private docStatusService: DoctorService) { }
  constructor(
  private docStatusService: DoctorstatusService,
  private route: ActivatedRoute
  ) { }

  ngOnInit() {
    // this.docStatusService.getDoctors().subscribe(response => {
    //   this.doctors = response as Doctor[]
    // })
    // this.docStatusService.getDoctors()
    //   .subscribe(data => {
        
    //     this.doctors.push(data)
    //   });
    this.employeeId = this.route.snapshot.params.employeeId

    this.docStatusService.getDocStatus()
    .subscribe(data => {
      this.doctorStatus = data as string
    });
     
    this.docStatusService.getCurrentQueuenumber()
    .subscribe(data => {
      this.totalQueue = data as string
    });

    this.docStatusService.getOwnQueueNo(this.employeeId).subscribe(data => {
      this.employeeId = parseInt(data)
      
    });




}

OnReserve(){
  this.addDocAppointment = new postData();
  this.addDocAppointment.employeeId = this.employeeId;
  this.addDocAppointment.patientId = this.employeeId;

  this.docStatusService.AddReserve(this.addDocAppointment).subscribe(
    data => console.log('Success', data),
    error => console.error('Error!',error)
      )
    }
}


