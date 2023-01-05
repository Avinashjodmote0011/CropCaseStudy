import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CropService } from 'src/app/services/crop.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-add-crop',
  templateUrl: './add-crop.component.html',
  styleUrls: ['./add-crop.component.css']
})
export class AddCropComponent implements OnInit {

  addCropForm!:FormGroup;
  userId!:number;
  

  constructor( private cropService:CropService , private router:Router , private tokenStorage:TokenStorageService ) { }

  ngOnInit(): void {

    const user=this.tokenStorage.getUser();
   this.userId=user.userId;

    this.addCropForm= new FormGroup({
      cropType: new FormControl('',Validators.required),      
      cropName:  new FormControl('',[Validators.required,Validators.minLength(3),Validators.pattern('^[a-zA-Z ]*$')]),
      phoneNumber: new FormControl('',[Validators.required,Validators.minLength(10),Validators.maxLength(10)]),
      quanity: new FormControl('',Validators.required),
      locationName: new FormControl('',[Validators.required,Validators.minLength(3)]),
      state: new FormControl('',Validators.required),
      district: new FormControl('',Validators.required),
      pincode: new FormControl('',[Validators.required,Validators.minLength(6),Validators.maxLength(6)]),
      userId:new FormControl('',Validators.required)
    })

  }

  onSubmit(){

    this.addCrop();
  }
  addCrop(){
    this.cropService.addCrop(this.addCropForm.value).subscribe(
      data =>{
        console.log(data);
        alert('Crop added...!')
      });
      this.router.navigate(['/getcropbyuser/:id']);
  }

  get cropType(){
    return this.addCropForm.get('cropType');
  }
  get cropName(){
    return this.addCropForm.get('cropName');
  }
  get quanity(){
    return this.addCropForm.get('quanity');
  }
  get userid(){
    return this.addCropForm.get('userId');
  }
  get phoneNumber(){
    return this.addCropForm.get('phoneNumber');
  }
  get locationName(){
    return this.addCropForm.get('locationName');
  }
  // get country(){
  //   return this.addCropForm.get('country');
  // }
  get state(){
    return this.addCropForm.get('state');
  }
  get district(){
    return this.addCropForm.get('district');
  }
  // get mandal(){
  //   return this.addCropForm.get('mandal');
  // }
  get pincode(){
    return this.addCropForm.get('pincode');
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
    this.router.navigate(['/getcropbyuser/:id']);
  }

  items: any[] = [
    { id: 1, name: 'one' },
    { id: 2, name: 'two' },
    { id: 3, name: 'three' },
    { id: 4, name: 'four' },
    { id: 5, name: 'five' },
    { id: 6, name: 'six' }
  ];
  selected: number = 1;

  selectOption(id: number) {
    //getted from event
    console.log(id);
    //getted from binding
    console.log(this.selected)
  }
}
