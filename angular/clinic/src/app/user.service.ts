import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http' ;
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private _url : string ='http://localhost:8080/api/login';
  readonly rootUrl = 'http://localhost:35257';

  constructor(private http: HttpClient) { }

  
  getUser(){
    return this.http.get(this._url, {responseType: "text"} );
    
  }

  userAuthentication(userName, password) {
    var data = "username=" + userName + "&password=" + password + "&grant_type=password";
    var reqHeader = new HttpHeaders({ 'Content-Type': 'application/x-www-urlencoded','No-Auth':'True' });
    return this.http.post(this.rootUrl + '/token', data, { headers: reqHeader });
  }
}
