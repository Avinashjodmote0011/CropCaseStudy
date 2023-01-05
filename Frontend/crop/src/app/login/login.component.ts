import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginRequest } from '../model/LoginRequest.model';
import { AuthService } from '../services/auth.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm!:FormGroup;
  loginrequest!:LoginRequest;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  id!:number;
  username?:string;
  // submitted=false;
  constructor( private authService:AuthService , private tokenStorage:TokenStorageService,
     private route:ActivatedRoute , private router:Router) { }

  ngOnInit(): void {

    this.loginForm =  new FormGroup({
      username:new FormControl(),
      password:new FormControl()
    })
    if(this.tokenStorage.getToken()){
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
      const user =this.tokenStorage.getUser();
      this.username=user.username;
    }
  }

  onSubmit(): void {
     this.authService.login(this.loginForm.value).subscribe(
      data => {

        this.tokenStorage.saveToken(data.accessToken);
        console.log(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.id = this.tokenStorage.getUser().userId;
        
       
        this.reloadPage();
        this.router.navigate(['home'])
      },
      err => {
        alert('login failed');
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
        
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }

}
