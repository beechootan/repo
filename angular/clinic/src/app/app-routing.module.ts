import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppointmentComponent} from './appointment/appointment.component'
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LoginNewComponent } from './login-new/login-new.component';


const routes: Routes = [
  { path: 'appointment', component: AppointmentComponent },
  { path: 'home/:employeeId', component: HomeComponent },
  { path: '',component: LoginComponent },
  { path: 'try',component: LoginNewComponent}
  // { path: 'home', component: HomeComponent },
  // { path: '',component: LoginComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
