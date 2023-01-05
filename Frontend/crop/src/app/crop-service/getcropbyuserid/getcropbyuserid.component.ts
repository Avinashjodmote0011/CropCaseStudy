import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CropService } from 'src/app/services/crop.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { Crop } from '../crop';


@Component({
  selector: 'app-getcropbyuserid',
  templateUrl: './getcropbyuserid.component.html',
  styleUrls: ['./getcropbyuserid.component.css']
})
export class GetcropbyuseridComponent implements OnInit {

  userId!:any;
  id!:number;
  crop!:Crop[];

  constructor( private cropService:CropService , private router:Router, private route:ActivatedRoute ,
            private tokenStorage:TokenStorageService) { }
            

  ngOnInit(): void {
   const user=this.tokenStorage.getUser();
   this.userId=user.userId;
   this.getCropByUserId();
  }
  user!:any;
 

  getCropByUserId(){
    this.cropService.getCropByUserId(this.userId).subscribe(
      data =>{
        this.crop=data;
        console.log('ALL',JSON.stringify(data))
      }
    );
  }
      deleteCropById(cropId:number){
        alert(cropId +' Delete..?')
        this.cropService.deleteByCropId(cropId).
        subscribe(data =>{
          console.log(data);
         
        });
        
        this.router.navigate(['/viewallcrop']);
       
      }

  onSubmit(){
    
  }

}
