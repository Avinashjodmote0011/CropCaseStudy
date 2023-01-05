package com.hr.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.client.BankDetailsClient;
import com.hr.client.CropProduct;
import com.hr.model.BankDetailsDto;
import com.hr.model.Crop;
import com.hr.model.CropDto;
import com.hr.model.PurchaseCrop;
import com.hr.model.User;
import com.hr.repositories.RoleRepository;
import com.hr.repositories.UserRepository;
import com.hr.services.UserService;
import com.hr.util.JwtUtils;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/hr")
@RestController
@EnableFeignClients(basePackages = "com.*")
public class HRController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	CropProduct cropclient;
	@Autowired
	BankDetailsClient bankclient;
	@Autowired
	UserService userservice;

	@GetMapping("/viewAllCrops")	
	public ResponseEntity<List<Crop>> getAllCrops() {
		return cropclient.getAll();
	}
	@PutMapping("/update")
	@PreAuthorize("hasRole('FARMER')or  hasRole('ADMIN')")
	public ResponseEntity<String> update(@RequestBody CropDto cropdto) {
		return cropclient.update(cropdto);

	}

	@GetMapping("/getcropbytype/{type}")
	@PreAuthorize("hasRole('FARMER') or hasRole('DEALER')")
	public ResponseEntity<Crop> viewBytype(@PathVariable String type) {
		return cropclient.viewBytype(type);
	}
	
	@GetMapping("/getbyuserId/{id}")
	public ResponseEntity<List<Crop>> getListByuser(@PathVariable int id){
		return cropclient.getListByuser(id);
	}
	@PostMapping("/add")
	@PreAuthorize("hasRole('FARMER')")
	public ResponseEntity<Crop> add(@RequestBody Crop crop){
		return cropclient.add(crop);
	}
	
	@PostMapping("/purchase")
	@PreAuthorize("hasRole('DEALER')")
	public ResponseEntity<PurchaseCrop> purchaseCrop(@RequestBody PurchaseCrop bankdto){
		BankDetailsDto bank=new BankDetailsDto(bankdto.getAccountNumber(),bankdto.getAmount());
		bankclient.credit(bank);
		cropclient.deleteCropbyId(bankdto.getCropId());
		return new ResponseEntity<>(bankdto,HttpStatus.OK);
	}
	@GetMapping("viewAllAccounts")
	public ResponseEntity<List<User>> getAllAccounts() {
		List<User> userlist = userservice.getAllAccounts();
		return new ResponseEntity<>(userlist, HttpStatus.OK);
	}
	
//	@GetMapping("viewAllFarmerAccounts/{role}")
//	@PreAuthorize("hasRole('DEALER') or hasRole('ADMIN')")
//	public ResponseEntity<List<User>> getAllFarmerAccounts(@PathVariable String role) {
//		List<User> userlist = userservice.getAllFarmerAccounts(role);
//		return new ResponseEntity<>(userlist, HttpStatus.OK);
//	}
	
//	@PutMapping("/update")
//	@PreAuthorize("hasRole('FARMER') or hasRole('DEALER') or hasRole('ADMIN')")
//	public ResponseEntity<String> updateProfile(@RequestBody User user){
//		String s=userservice.update(user);
//		return new ResponseEntity<>(s,HttpStatus.OK);
//	}
//	
	@DeleteMapping("/delete/{id}")
//	@PreAuthorize(" hasRole('ADMIN')")
	public ResponseEntity<String> deleteAccount(@PathVariable int id){
		String s=userservice.delete(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	
}
