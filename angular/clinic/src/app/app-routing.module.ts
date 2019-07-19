import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppointmentComponent} from './appointment/appointment.component'
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  { path: 'appointment', component: AppointmentComponent },
  { path: '', component: HomeComponent },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
