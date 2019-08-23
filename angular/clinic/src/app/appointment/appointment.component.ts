import { Component, OnInit } from '@angular/core';
import { appointmentService } from '../appointment.service'
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.scss']
})
export class AppointmentComponent implements OnInit {
  public appointments:any = [];
  employeeId: string
  nurseId : number
  appointmentId: number

  constructor(
    private appointmentStatus: appointmentService,
    private route: ActivatedRoute
    ){ }

  ngOnInit() {
    this.employeeId = this.route.snapshot.params.employeeId

    this.appointmentStatus.getAppStatus()
    .subscribe(data => {
      this.appointments = data
    });

    
   
  }

  onCheckIn(id){
      this.appointmentStatus.checkInTime(parseInt(this.employeeId), id).subscribe(
        data => {
          console.log(data)
          this.appointmentStatus.getAppStatus()
          .subscribe(data => {
            this.appointments = data
          });
        })
      };

      onCheckOut(id){
        this.appointmentStatus.checkOutTime(parseInt(this.employeeId), id).subscribe(
          data => {
            console.log(data)
            this.appointmentStatus.getAppStatus()
            .subscribe(data => {
              this.appointments = data
            });
          })
        };

  }

