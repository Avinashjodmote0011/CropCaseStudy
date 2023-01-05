import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from './user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  addUserFrom!: FormGroup;
  role!:User[];

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {

    this.addUserFrom = new FormGroup({

      username: new FormControl('', [Validators.required, Validators.minLength(3)]),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      phoneNumber: new FormControl('', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
    });

  }

  onSubmit() {
    this.addUsers();
  }

  public addUsers() {
    this.userService.addUsers(this.addUserFrom.value).subscribe(
      data => {
        console.log(data);
        alert('Account created successfully...!')
        this.router.navigate(['/login']);
      }
    );
  }

  get username() {
    return this.addUserFrom.get('username');
  }
  get email() {
    return this.addUserFrom.get('email');
  }
  get roles() {
    return this.addUserFrom.get('roles');
  }
  get password() {
    return this.addUserFrom.get('password');
  }
  get phoneNumber() {
    return this.addUserFrom.get('phoneNumber');
   }

  keyPressNumbers(event: any) {

    var charCode = (event.which) ? event.which : event.keyCode;

    if ((charCode < 48 || charCode > 57)) {

      event.preventDefault();

      return false;

    } else {

      return true;

    }

  }
  letterOnly(event: any): Boolean {
    const charCode = (event.which) ? event.which : event.keyCode;
    if ((charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122)) {
      return false;
    }
    return true;
  }

}
