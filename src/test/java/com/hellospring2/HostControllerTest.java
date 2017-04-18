package com.hellospring2;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class HostControllerTest {
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new HostController()).build();
	}
	
	@Test
	public void employeeNotFound() throws Exception {
		this.mockMvc.perform(get("/host/employees?id=4")).andExpect(status().isNotFound());
	}

}
