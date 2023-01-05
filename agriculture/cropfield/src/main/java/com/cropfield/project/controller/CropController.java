package com.cropfield.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cropfield.project.Model.Crop;
import com.cropfield.project.Model.CropDto;
import com.cropfield.project.exceptions.CropNotFoundException;
import com.cropfield.project.exceptions.UserNotFoundException;
import com.cropfield.project.service.CropService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/crop")
public class CropController {
	
	Logger logger =LoggerFactory.getLogger(CropController.class);
	
	@Autowired
	public CropService cropservice;

	@PostMapping("/add")
	public ResponseEntity<Crop> add(@RequestBody Crop crop) {
		logger.info("you are inside of add controller method");
		Crop c = cropservice.addCrop(crop);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody CropDto cropdto) throws CropNotFoundException {
		logger.info("you are inside of update controller method");
		String s = cropservice.UpdateCrop(cropdto);
		return new ResponseEntity<String>(s, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<Crop>> getAll()  {
		
		logger.info("Your are inside of getAll controller method");
		
		List<Crop> list = cropservice.getAllCropDetails();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getcropbyId/{id}")
	public ResponseEntity<Crop> getById(@PathVariable int id) throws CropNotFoundException {
		logger.info("You are inside of getById controller method which return specified cropid details");
		Crop c = cropservice.getCropbyId(id);		
		return new ResponseEntity<>(c, HttpStatus.OK);
		
	}

	@DeleteMapping("/deletebyId/{id}")
	public ResponseEntity<String> deleteCropbyId(@PathVariable int id) throws MethodArgumentTypeMismatchException, CropNotFoundException {
		logger.info("Yor are inside of deleteCropbyId controller method");
		String s = cropservice.deleteCrop(id);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@GetMapping("/getcropbytype/{type}")
	public ResponseEntity<List<Crop> > viewBytype(@PathVariable String type) throws CropNotFoundException {
		logger.info("Your are inside of viewByType controller method");
		List<Crop> c = cropservice.getCropbyType(type);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	@GetMapping("/getcropbyname/{name}")
	public ResponseEntity<List<Crop> > viewByname(@PathVariable String name) throws CropNotFoundException {
		logger.info("you are inside of viewByname controller method");
		List<Crop>  c = cropservice.getbyCropName(name);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	@GetMapping("/getbyuserId/{id}")
	public ResponseEntity<List<Crop>> getListByuser(@PathVariable int id) throws UserNotFoundException{
		logger.info("you are inside of getListByuser controller method");
		List<Crop> c=cropservice.getbyuserId(id);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
}
