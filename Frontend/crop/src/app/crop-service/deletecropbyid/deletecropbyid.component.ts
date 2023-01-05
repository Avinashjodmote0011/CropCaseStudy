import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CropService } from 'src/app/services/crop.service';
import { Crop } from '../crop';

@Component({
  selector: 'app-deletecropbyid',
  templateUrl: './deletecropbyid.component.html',
  styleUrls: ['./deletecropbyid.component.css']
})
export class DeletecropbyidComponent implements OnInit {

  crop!:Crop;
  cropid!:any;

  constructor( private cropService:CropService , private router:Router, private route:ActivatedRoute ) { }

  
  ngOnInit(): void {
    const cropid =Number(this.route.snapshot.paramMap.get('id'));
    this.cropid=cropid;
  }
  
  
  delete(){
    this.deleteCropById();
    }
      deleteCropById(){
        this.cropService.deleteByCropId(this.cropid).
        subscribe(data =>{
          console.log(data);
          this.router.navigate(['viewallcrop']);
        });
      }

}
