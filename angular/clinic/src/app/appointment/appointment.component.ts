import { Component, OnInit } from '@angular/core';
import { appointmentService } from '../appointment.service'

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.scss']
})
export class AppointmentComponent implements OnInit {
  public appointments:any = [];

  constructor(private appointmentStatus: appointmentService) { }

  ngOnInit() {
    this.appointmentStatus.getAppStatus()
    .subscribe(data => {
      debugger
      this.appointments.push(data)
    });
   
  }

}
