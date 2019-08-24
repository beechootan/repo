import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LocationStrategy, PathLocationStrategy } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { LoginNewComponent } from './login-new/login-new.component';

@NgModule({
  declarations: [
    AppComponent,
    AppointmentComponent,
    HomeComponent,
    LoginComponent,
    LoginNewComponent
  ],
  imports: [
    BrowserModule,RouterModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [{ provide: LocationStrategy, useClass: PathLocationStrategy }],
  bootstrap: [AppComponent]
})
export class AppModule { }
