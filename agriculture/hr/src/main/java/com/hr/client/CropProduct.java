package com.hr.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hr.model.Crop;
import com.hr.model.CropDto;



@FeignClient(url="http://localhost:8535/crop",name = "crop-client")
public interface CropProduct {
	@GetMapping("/viewAll")
	public ResponseEntity<List<Crop>>getAll();
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody CropDto cropdto);
	@GetMapping("/getcropbytype/{type}")
	public ResponseEntity<Crop> viewBytype(@PathVariable String type);
	@GetMapping("/getbyuserId/{id}")
	public ResponseEntity<List<Crop>> getListByuser(@PathVariable int id);
	@PostMapping("/add")
	public ResponseEntity<Crop> add(@RequestBody Crop crop);
	@DeleteMapping("/deletebyId/{id}")
	public ResponseEntity<String> deleteCropbyId(@PathVariable int id) ;

	@GetMapping("/getcropbyId/{id}")
	public ResponseEntity<Crop> getById(@PathVariable int id);


	@GetMapping("/getcropbyname/{name}")
	public ResponseEntity<List<Crop>> viewByname(@PathVariable String name);
}
