import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { CropService } from 'src/app/services/crop.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { User } from 'src/app/signup/user';
import { Crop } from '../crop';
import { DeletecropbyidComponent } from '../deletecropbyid/deletecropbyid.component';

@Component({
  selector: 'app-view-all-crop',
  templateUrl: './view-all-crop.component.html',
  styleUrls: ['./view-all-crop.component.css']
})
export class ViewAllCropComponent implements OnInit {

sub!:Subscription;
crop!:Crop[];
type!:string;
cropid!:number;
cropName!:string;
errorMessage!:any;

id!:number;
roles!:string;

userid!:any;

  constructor( private cropService:CropService , private router:Router , 
    private routr:ActivatedRoute , private tokenStorage:TokenStorageService) { }

  ngOnInit(): void {
    const user = this.tokenStorage.getUser();
   this.roles = user.roles;
    this.viewAllCrop();
  }



  viewAllCrop(){
    this.sub = this.cropService.getAllCrop().subscribe(
      data => {
        this.crop=data;
        console.log('ALL:',JSON.stringify(data));
      }
    )
   
  }

  getCropByUserId(){
    this.cropService.getCropByUserId(this.userid).subscribe(
      data =>{
        this.crop=data;
        console.log('ALL',JSON.stringify(data))
        
      }, err => {
        this.errorMessage=err.error.message;
        this.errorMessage="invalid id..."
        alert(this.errorMessage);

      }
    );
  }
  onSubmit(){
    this.getCropByUserId();
  }


  viewCropType(){
    
    this.viewCropByType();

  }

  viewCropByType(){
    this.sub=this.cropService.getCropByCropType(this.type).subscribe(
      data =>{
        this.crop=data;
        console.log('ALL',JSON.stringify);
      }
    )
    
  }
reloadPage(){
  window.location.reload();
}


  viewCropId(){
    this.getCropById();
  }

  getCropById(){
    this.cropService.getCropById(this.cropid).subscribe(
      data =>{
        this.crop=data;
        console.log(data);
      });
  }
  delete(id:number){
    
    alert('delete this crop with id '+id);
    this.cropService.deleteByCropId(id).subscribe(data=>{
      this.crop=data;
      console.log(data);
    });
    this.reloadPage();
  }

  viewCropName(){
    this.getCropByName();
  }

  getCropByName(){
    this.cropService.getCropByName(this.cropName).subscribe(
      data =>{
        this.crop=data;
        console.log(data);
        if(data == null){
          return alert('invalid')
        }
      }
      
    )
  }
  letterOnly(event:any) : Boolean{
    const charCode = (event.which) ? event.which : event.keyCode;
    if ((charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122)) {
      return false;
    }
    return true;
  }
  keyPressNumbers(event: any) {
    var charCode = (event.which) ? event.which : event.keyCode;
    if ((charCode < 48 || charCode > 57)) 
    {
      event.preventDefault();
      return false;
    } else
     {
      return true;
    }
  }
  
  back(){
    this.router.navigate(['/viewallcrop']);
  }

 
}
