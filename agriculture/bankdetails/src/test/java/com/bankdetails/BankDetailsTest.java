package com.bankdetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bankdetails.Models.BankDetails;
import com.bankdetails.repositories.BankRepository;
import com.bankdetails.service.BankService;
import com.bankdetails.service.BankServiceImpl;

@SpringBootTest
public class BankDetailsTest {
	
	@InjectMocks
	BankService bankService = new BankServiceImpl();
	@Mock
	BankRepository bankRepository;
	
	@Test
	void testAdd() {
		
		BankDetails bankDetails = new BankDetails();
		bankDetails.setAccountNumber(11223344l);
		bankDetails.setAccountHolderName("mike");
		bankDetails.setBankCode("ifsc00001");
		bankDetails.setBankName("SBI");
		bankDetails.setBranchName("pune");
		bankDetails.setBalance(2000.00);
		
		when(bankRepository.save(bankDetails)).thenReturn(bankDetails);
		BankDetails bankDetails2 = bankService.add(bankDetails);
		assertNotNull(bankDetails2);
		assertEquals("mike", bankDetails2.getAccountHolderName());
	}
	
	@Test
	void TestViewAll() {
		
		BankDetails bankDetails = new BankDetails();
		bankDetails.setAccountNumber(11223344l);
		bankDetails.setAccountHolderName("mike");
		bankDetails.setBankCode("ifsc00001");
		bankDetails.setBankName("SBI");
		bankDetails.setBranchName("pune");
		bankDetails.setBalance(2000.00);
		
		BankDetails bankDetails2 = new BankDetails();
		bankDetails2.setAccountNumber(11223345l);
		bankDetails2.setAccountHolderName("bob");
		bankDetails2.setBankCode("ifsc00001");
		bankDetails2.setBankName("Kotak");
		bankDetails2.setBranchName("haveli, pune");
		bankDetails2.setBalance(5000.00);
		
		List<BankDetails> viewAllList = new ArrayList<>();
		viewAllList.add(bankDetails);
		viewAllList.add(bankDetails2);
		
		when(bankRepository.findAll()).thenReturn(viewAllList);
		List<BankDetails> bank = bankService.viewAll();
		assertNotNull(bank);
		assertEquals(2, bank.size());
	}
	
	@Test
	void testDelete() {
		
		BankDetails bankDetails = new BankDetails();
		bankDetails.setAccountNumber(11223344l);
		bankDetails.setAccountHolderName("mike");
		bankDetails.setBankCode("ifsc00001");
		bankDetails.setBankName("SBI");
		bankDetails.setBranchName("pune");
		bankDetails.setBalance(2000.00);
		
		when(bankRepository.findByAccountNumber(11223344l)).thenReturn(bankDetails);
		bankService.deletebyId(11223344l);
	}
	
	@Test
	void testGetById() {
		BankDetails bankDetails = new BankDetails();
		bankDetails.setAccountNumber(11223344l);
		bankDetails.setAccountHolderName("mike");
		bankDetails.setBankCode("ifsc00001");
		bankDetails.setBankName("SBI");
		bankDetails.setBranchName("pune");
		bankDetails.setBalance(2000.00);
		
		when(bankRepository.findByAccountNumber(11223344l)).thenReturn(bankDetails);
		BankDetails bd = bankService.getById(11223344l);
		assertEquals("SBI", bd.getBankName());
		assertEquals(11223344l, bd.getAccountNumber());
		assertEquals("ifsc00001", bd.getBankCode());
		assertEquals("pune", bd.getBranchName());
		assertEquals(2000.00, bd.getBalance());
	}

}
