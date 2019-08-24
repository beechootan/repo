import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { UserService } from '../user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  userService: any;
  isLoginError: boolean;
  router: any;
  employeeId: string;

  constructor() { }

  ngOnInit() {
  }

//   OnSubmit(inputEmail,inputPassword){
//     this.userService.userAuthentication(inputEmail,inputPassword).subscribe((data : any)=>{
//      localStorage.setItem('userToken',data.access_token);
//     //  this.router.navigate(['/home']);
//     this.router.navigate(["./home"]);
//    },
//    (err : HttpErrorResponse)=>{
//      this.isLoginError = true;
//    });
//  }

 OnSubmit(inputEmail,inputPassword){
   console.log("TESTING 123")
  this.userService.getUser(inputEmail,inputPassword).subscribe((data : any)=>{
  //  localStorage.setItem('userToken',data.access_token);
  //  this.router.navigate(['/home']);
  this.employeeId=data as string;
  this.router.navigate(["./home/{{ employeeId }}"]);
 },
 (err : HttpErrorResponse)=>{
   this.isLoginError = true;
 });
}


}
