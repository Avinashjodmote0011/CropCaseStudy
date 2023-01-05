package com.cropfield.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cropfield.project.Model.Crop;
import com.cropfield.project.Model.CropDto;
import com.cropfield.project.exceptions.CropNotFoundException;
import com.cropfield.project.exceptions.UserNotFoundException;

@Service
public interface CropService {
	Crop addCrop(Crop crop);

	String UpdateCrop(CropDto cropdto) throws CropNotFoundException;

	List<Crop> getAllCropDetails() throws NullPointerException;

	Crop getCropbyId(int id) throws CropNotFoundException  ; 

	String deleteCrop(int id) throws CropNotFoundException;

	List<Crop> getCropbyType(String croptype) throws CropNotFoundException;

	List<Crop> getbyCropName(String name)throws CropNotFoundException;

	List<Crop> getbyuserId(int id) throws UserNotFoundException;

}
