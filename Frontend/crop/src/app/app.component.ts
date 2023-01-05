import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from './services/token-storage.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title(title: any) {

    throw new Error('Method not implemented.');

  }

  private roles: string[] = [];

  isLoggedIn = false;

  showAdminBoard = false;

  showFarmerDashboard = false;

  showDealerDashboard=false;

  username?: string;



  constructor(private tokenStorageService: TokenStorageService , private router:Router) { }



  ngOnInit(): void {

    this.isLoggedIn = !!this.tokenStorageService.getToken();



    if (this.isLoggedIn) {

      const user = this.tokenStorageService.getUser();

      this.roles = user.roles;



      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');

      this.showFarmerDashboard = this.roles.includes('ROLE_FARMER');

      this.showDealerDashboard=this.roles.includes('ROLE_DEALER');

      this.username = user.username;

    }

  }
   logout(): void {

    this.tokenStorageService.signOut();
    this.router.navigate(['home'])
    // window.location.reload();
    

  }
}
