import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { TokenStorageService } from '../services/token-storage.service';
import { UserService } from '../services/user.service';
import { User } from '../signup/user';

@Component({
  selector: 'app-view-all-user',
  templateUrl: './view-all-user.component.html',
  styleUrls: ['./view-all-user.component.css']
})
export class ViewAllUserComponent implements OnInit {

  sub!:Subscription;
  user!:User[];
  u!:any;
  roles!:string;


  constructor( private userService:UserService , private router:Router ,
    private tokenStorage:TokenStorageService) { }

  ngOnInit(): void {
    const user = this.tokenStorage.getUser();
    this.roles = user.roles;
    this.viewAllUser();

  }
  viewAllUser(){

    this.sub = this.userService.viewAllUser().subscribe(
      data => {
        this.user=data;
        console.log('ALL:',JSON.stringify(data));
      }
    )
  }
  
  delete(id:number){
    alert('this Userid '+id+' will be delete...?')
    this.userService.delete(id).subscribe(data=>{
      this.u=data;
      console.log(data);
      
    });
    alert('userid '+id+' is deleted')
    this.router.navigate(['/admin'])
  }

}
