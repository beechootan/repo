import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service'
// import { DocStatusService } from '../doctorstatus.service'

interface Doctor {
  id: number
  status: boolean
}



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  doctors: Doctor[] = []


  constructor(private docStatusService: DoctorService) { }

  ngOnInit() {
    this.docStatusService.getDoctors().subscribe(response => {
      this.doctors = response as Doctor[]
    })
  }

}
