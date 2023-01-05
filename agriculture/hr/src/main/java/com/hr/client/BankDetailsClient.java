package com.hr.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hr.model.BankDetails;
import com.hr.model.BankDetailsDto;

@FeignClient(url = "http://localhost:8536/bank", name = "bank-client")
public interface BankDetailsClient {
	@GetMapping("/viewAllBankDetails")
	public ResponseEntity<List<BankDetails>> getAllBankDetials();

	@GetMapping("/viewByAccountNumber/{id}")
	public ResponseEntity<BankDetails> detailsByAccountnumber(@PathVariable Long id);

	@PutMapping("/deposit")
	public ResponseEntity<String> credit(@RequestBody BankDetailsDto bank);
}
