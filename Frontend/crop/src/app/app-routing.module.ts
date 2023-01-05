import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AddCropComponent } from './crop-service/add-crop/add-crop.component';
import { DeletecropbyidComponent } from './crop-service/deletecropbyid/deletecropbyid.component';
import { GetcropbyidComponent } from './crop-service/getcropbyid/getcropbyid.component';
import { GetcropbytypeComponent } from './crop-service/getcropbytype/getcropbytype.component';
import { GetcropbyuseridComponent } from './crop-service/getcropbyuserid/getcropbyuserid.component';
import { UpdateCropComponent } from './crop-service/update-crop/update-crop.component';
import { ViewAllCropComponent } from './crop-service/view-all-crop/view-all-crop.component';
import { DealerDashboardComponent } from './dealer-dashboard/dealer-dashboard.component';
import { FarmerDashboardComponent } from './farmer-dashboard/farmer-dashboard.component';
import { HomePageComponent } from './home-page/home-page/home-page.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ProfileComponent } from './profile/profile.component';
import { SignupComponent } from './signup/signup.component';
import { ViewAllUserComponent } from './view-all-user/view-all-user.component';

const routes: Routes = [
  {path:'',redirectTo:'/home', pathMatch:'full'},
  {path:'viewallcrop' , component:ViewAllCropComponent },
  {path:'getcropbycrop/:id' , component:GetcropbyidComponent },
  {path:'getcropbyuser/:id' , component:GetcropbyuseridComponent},
  {path:'updatecrop/:id' , component:UpdateCropComponent},
  {path:'signup', component:SignupComponent},
  {path:'getcropbytype/:type', component:GetcropbytypeComponent},
  {path:'home' , component:HomePageComponent},
  {path:'addcrop' , component:AddCropComponent},
  {path:'delete/:id' , component:DeletecropbyidComponent},
  {path:'login' , component:LoginComponent},
  {path:'admin',component:AdminDashboardComponent},
  {path:'farmer', component:FarmerDashboardComponent},
  {path:'dealer',component:DealerDashboardComponent},
  {path:'viewalluser' ,component:ViewAllUserComponent},
  {path:'profile', component:ProfileComponent},
  {path:'**',component:PageNotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
