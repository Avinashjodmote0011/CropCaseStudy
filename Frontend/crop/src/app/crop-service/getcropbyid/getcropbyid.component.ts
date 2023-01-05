import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CropService } from 'src/app/services/crop.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { Crop } from '../crop';

@Component({
  selector: 'app-getcropbyid',
  templateUrl: './getcropbyid.component.html',
  styleUrls: ['./getcropbyid.component.css']
})
export class GetcropbyidComponent implements OnInit {

  id!:number;
  crop!:Crop;
  constructor( private cropService:CropService , private router:Router,
     private route:ActivatedRoute , private tokenStorage:TokenStorageService ) { }

  ngOnInit( ): void {
    const cropid =Number(this.route.snapshot.paramMap.get('id'));
    this.id=cropid;
   
      this.cropService.getCropById(this.id).subscribe(
        data =>{
          this.crop=data;
          console.log(data);
        }
      )
    }
    onSubmit(){
      this.getCropById();
    }
    getCropById(){
      this.cropService.getCropById(this.id).subscribe(
        data =>{
          this.crop=data;
          console.log(data);
        },error=>{
          alert("Invalid id ...");
        }
        );
    }

     
  delete(){
    this.deleteCropById();
    }
      deleteCropById(){
        alert(this.id +'Delete..?')
        this.cropService.deleteByCropId(this.id).
        subscribe(data =>{
          console.log(data);
         
        });
        
        this.router.navigate(['/viewallcrop']);
        // this.reloadPage();
      }

      back(){
        this.router.navigate(['/viewallcrop']);
      }
      reloadPage(){
        window.location.reload();
      }
  }

  
  

  


