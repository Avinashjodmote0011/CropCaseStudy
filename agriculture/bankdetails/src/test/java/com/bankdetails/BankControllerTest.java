package com.bankdetails;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bankdetails.Models.BankDetails;
import com.bankdetails.Models.BankDetailsDto;
import com.bankdetails.controller.BankController;
import com.bankdetails.service.BankService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class BankControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private BankService bankService;
	private BankDetails bankDetails;
	private List<BankDetails> bankDetailsList;
	private BankDetailsDto bankDetailsDto;
	
	@InjectMocks
	private BankController bankController;
	
	@BeforeEach
	public void setUp() {
		bankDetails = new BankDetails(1122334455l, "Avinash jodmote", "Bank Of India", "Haveli,Pune", "IFSC000123", 20000.0,1002,"Avinash");
		bankDetailsDto = new BankDetailsDto(1122334455l,1000.0,"Avinash");
		mockMvc = MockMvcBuilders.standaloneSetup(bankController).build(); 
	}
	
	@Test
	void addBankTest() throws Exception{
		when(bankService.add(any())).thenReturn(bankDetails);
		mockMvc.perform(post("/bank/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(bankDetails)))
				.andExpect(status().isCreated());
		verify(bankService, times(1)).add(any());	
	}
	
	@Test
	void viewAllBankTest() throws Exception{
		when(bankService.viewAll()).thenReturn(bankDetailsList);
		mockMvc.perform(MockMvcRequestBuilders.get("/bank/viewAllBankDetails")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(bankDetails)))
				.andDo(MockMvcResultHandlers.print());
				verify(bankService,times(1)).viewAll();
	}
	
	@Test
	void viewByAccountNumberTest() throws Exception{
		when(bankService.getById(bankDetails.getAccountNumber())).thenReturn(bankDetails);
		mockMvc.perform(MockMvcRequestBuilders.get("/bank/viewByAccountNumber/1122334455")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(bankDetails)))
				.andDo(MockMvcResultHandlers.print());
				verify(bankService,times(1)).getById(1122334455l);
	}
	
//	@Test
//	void creditTest() throws Exception{
//		when(bankService.deposit(bankDetailsDto)).thenReturn(asJsonString(bankDetailsDto));
//		mockMvc.perform(post("/bank/deposit")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(asJsonString(bankDetails)))
//		.andDo(MockMvcResultHandlers.print());
//		verify(bankService,times(1)).deposit(bankDetailsDto);
//	}
	
	@Test
	void deleteBankTest() throws Exception{
		bankService.deletebyId(bankDetails.getAccountNumber());
		mockMvc.perform(MockMvcRequestBuilders.delete("/bank/deleteAccount/1122334455",1)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(bankDetails)))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
