import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../signup/user';

const url1='http://localhost:9000/hr/';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  

   addUserUrl = "http://localhost:9000/api/auth/signup/";
  

  constructor( private http:HttpClient ) { }

  addUsers( user:User ) : Observable<any>{
    
    return this.http.post<User>(this.addUserUrl , user);
  }
  viewAllUser():Observable<any> {
    return this.http.get<User[]>(url1 + 'viewAllAccounts');
  }
  delete(id:number){
    return this.http.delete(url1+'delete/'+id);
  }
}
