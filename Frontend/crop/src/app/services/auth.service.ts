import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginRequest } from '../model/LoginRequest.model';


const AUTH_API = 'http://localhost:9000/api/auth/';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor( private http: HttpClient ) { }

  login(loginrequest:LoginRequest): Observable<any> {
    return this.http.post(AUTH_API + 'signin',loginrequest, httpOptions);
  }
}
