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

  employeeId: string
  lastUpdBy: string
  public doctors:any = [];
  doctorStatus: string = null;
  empQueueNo: string = null;
  totalQueue: string = null;
  addDocAppointment : postData;

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

    this.docStatusService.getOwnQueueNo(parseInt(this.employeeId)).subscribe(data => {
      this.empQueueNo = data as string
      
    });




}

// OnReserve(){
//   this.patientId = this.employeeId;
//   this.docStatusService.AddReserve(parseInt(this.employeeId), parseInt(this.patientId)).subscribe(
//     data => {
//       console.log(data.body)
//     })
//   };

OnReserve(){
  this.addDocAppointment = new postData();
  this.addDocAppointment.employeeId = parseInt(this.employeeId);
  this.addDocAppointment.lastUpdBy = parseInt(this.employeeId);

  this.docStatusService.AddReserve(this.addDocAppointment).subscribe(
    data => {
            console.log(data)
          })
    }
}



