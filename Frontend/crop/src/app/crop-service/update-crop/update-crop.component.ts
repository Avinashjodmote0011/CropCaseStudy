import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { CropService } from 'src/app/services/crop.service';
import { Crop } from '../crop';

@Component({
  selector: 'app-update-crop',
  templateUrl: './update-crop.component.html',
  styleUrls: ['./update-crop.component.css']
})
export class UpdateCropComponent implements OnInit {

  crop!: Crop;
  sub!: Subscription;
  response!: Response;
  updateCropForm!: FormGroup;
  id!: number;
  message!: any;



  constructor(private cropService: CropService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {

    this.updateCropForm = new FormGroup({
      cropId: new FormControl(''),
      cropType: new FormControl('', Validators.required),
      cropName: new FormControl('', [Validators.required, Validators.minLength(3)]),
      phoneNumber: new FormControl('', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
      quanity: new FormControl('', [Validators.required, Validators.minLength(3)]),
      locationName: new FormControl('', [Validators.required, Validators.minLength(3)]),
      state: new FormControl('', [Validators.required, Validators.minLength(3)]),
      district: new FormControl('',[Validators.required, Validators.minLength(3)]),
      pincode: new FormControl('', [Validators.required, Validators.minLength(6), Validators.maxLength(6)])
    });

    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.id = id;
    console.log('id');

    this.getCropByCropId();
   }
   get cropType(){
     return this.updateCropForm.get('cropType');
   }
   get cropName(){
     return this.updateCropForm.get('cropName');
   }
   get quanity(){
     return this.updateCropForm.get('quanity');
   }
   get userid(){
     return this.updateCropForm.get('userId');
   }
   get phoneNumber(){
     return this.updateCropForm.get('phoneNumber');
   }
   get locationName(){
     return this.updateCropForm.get('locationName');
   }
   get state(){
    return this.updateCropForm.get('state');
  }
  get district(){
    return this.updateCropForm.get('district');
  }
  get pincode(){
    return this.updateCropForm.get('pincode');
  }

  onSubmit() {
    this.updateCrop();
  }
  updateCrop() {
    this.cropService.updateCrop(this.updateCropForm.value).subscribe(
      data => {
        this.response = data;
        console.log({ data: 'updated' });
        alert('updated...!')
      });
    this.router.navigate(['/viewallcrop']);
  }
  back() {
    this.router.navigate(['/viewallcrop']);
  }

  getCropByCropId() {

    this.sub = this.cropService.getCropById(this.id).subscribe(
      data => {
        this.crop = data;
        this.updateCropForm.patchValue({
          cropId: this.id,
          cropType: this.crop.cropType,
          cropName: this.crop.cropName,
          quanity: this.crop.quanity,
          phoneNumber: this.crop.phoneNumber,
          locationName: this.crop.locationName,
          state: this.crop.state,
          district: this.crop.district,
          pincode: this.crop.pincode
        })
        console.log('Get Crop', JSON.stringify(data));
      }
    )
  }


  letterOnly(event: any): Boolean {
    const charCode = (event.which) ? event.which : event.keyCode;
    if ((charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122)) {
      return false;
    }
    return true;
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

}
