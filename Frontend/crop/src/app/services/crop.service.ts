import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Crop } from '../crop-service/crop';

@Injectable({
  providedIn: 'root'
})
export class CropService {

  private cropUrl ="http://localhost:8537/crop/";
  private addCropUrl = "http://localhost:8535/crop/add/";
  private updateCropUrl ="http://localhost:8535/crop/update/";
  private deleteCropUrl="http://localhost:8535/crop/deletebyId/";

  constructor( private http:HttpClient ) { }

  addCrop(crop : Crop):Observable<any>{
    return this.http.post<any>(this.addCropUrl,crop);
  }

  getAllCrop():Observable<any>{
    return this.http.get<Crop[]>(this.cropUrl+"viewAll");
  }

  getCropById(id:number):Observable<any>{
    return this.http.get<Crop[]>(this.cropUrl+"getcropbyId/"+id);
  }

  updateCrop(crop:Crop):Observable<any>{
    
    return this.http.put<Crop>(this.updateCropUrl,crop,{responseType:'text' as 'json'});
  }

  getCropByUserId(id:number):Observable<any>{
    return this.http.get<Crop[]>(this.cropUrl+"getbyuserId/"+id);
  }
  getCropByCropType(type:string):Observable<any>{
    return this.http.get<Crop[]>(this.cropUrl+"getcropbytype/"+type);
  }

  getCropByName(name:string):Observable<any>{
    return this.http.get<Crop[]>(this.cropUrl+"getcropbyname/"+name);
  }

  deleteByCropId(id:number):Observable<any>{
    return this.http.delete<Crop>(this.deleteCropUrl+id);
  }
}
