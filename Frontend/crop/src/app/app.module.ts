import { NgModule } from '@angular/core';
import { ReactiveFormsModule , FormsModule} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { AddCropComponent } from './crop-service/add-crop/add-crop.component';
import { ViewAllCropComponent } from './crop-service/view-all-crop/view-all-crop.component';
import { UpdateCropComponent } from './crop-service/update-crop/update-crop.component';
import { GetcropbyidComponent } from './crop-service/getcropbyid/getcropbyid.component';
import { GetcropbyuseridComponent } from './crop-service/getcropbyuserid/getcropbyuserid.component';
import { HomePageComponent } from './home-page/home-page/home-page.component';
import { GetcropbytypeComponent } from './crop-service/getcropbytype/getcropbytype.component';
import { DeletecropbyidComponent } from './crop-service/deletecropbyid/deletecropbyid.component';
import { LoginComponent } from './login/login.component';
import { FarmerDashboardComponent } from './farmer-dashboard/farmer-dashboard.component';
import { DealerDashboardComponent } from './dealer-dashboard/dealer-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ProfileComponent } from './profile/profile.component';
import { ViewAllUserComponent } from './view-all-user/view-all-user.component';
import { FooterComponent } from './footer/footer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { BackButtonDisableModule } from 'angular-disable-browser-back-button';



@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    AddCropComponent,
    ViewAllCropComponent,
    UpdateCropComponent,
    GetcropbyidComponent,
    GetcropbyuseridComponent,
    HomePageComponent,
    GetcropbytypeComponent,
    DeletecropbyidComponent,
    LoginComponent,
    FarmerDashboardComponent,
    DealerDashboardComponent,
    AdminDashboardComponent,
    ProfileComponent,
    ViewAllUserComponent,
    FooterComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule,
    HttpClientModule,
    BackButtonDisableModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
