import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { CropService } from 'src/app/services/crop.service';
import { Crop } from '../crop';

@Component({
  selector: 'app-getcropbytype',
  templateUrl: './getcropbytype.component.html',
  styleUrls: ['./getcropbytype.component.css']
})
export class GetcropbytypeComponent implements OnInit {

  crop!:Crop[];
  type!:string;
  sub!:Subscription;

  constructor( private cropService:CropService , private router:Router , private route:ActivatedRoute ) { }

  ngOnInit(): void {
  }

  onSubmit(){
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

}
