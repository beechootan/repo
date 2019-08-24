import { Component, OnInit } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl, Validator, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login-new',
  templateUrl: './login-new.component.html',
  styleUrls: ['./login-new.component.scss']
})
export class LoginNewComponent implements OnInit {
  userService: any;
  isLoginError: boolean;
  router: any;
  employeeId: string;


  // loginForm = new FormGroup({
  //   email: new FormControl('', Validators.compose([Validators.required])),
  //   password: new FormControl('', Validators.compose([Validators.required]))
  // });


  constructor() { }

  ngOnInit() {
  }


//   OnSubmit1() {
//     console.log("TESTING 123");  
    
//    this.userService.getUser(email,password).subscribe((data : any)=>{
//    this.employeeId=data as string;
//    this.router.navigate(["./home/{{employeeId}}"]);
//   },
//   (err : HttpErrorResponse)=>{
//     this.isLoginError = true;
//   });
//  }


 OnSubmit(UserName,Password){
  console.log("TESTING 123");
  console.log(UserName);
  console.log(Password);

 
   this.userService.getUser(UserName,Password).subscribe((data : any)=>{
    this.employeeId=data as string;
    this.router.navigate(["./home/{{employeeId}}"]);
    // this.router.navigate(["./home/7"]);
 },
 (err : HttpErrorResponse)=>{
   this.isLoginError = true;
 });
}

 
}
