package com.hellospring2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/host")
public class HostController {
	
	List<Employee> list = new ArrayList<>();
	
	@RequestMapping(value="/employees/{id}")
	public String employeeGetSpecific(@RequestParam String id) throws JsonProcessingException {
		list.add(new Employee("1", "John", "male"));
		list.add(new Employee("2", "Jim", "male"));
		list.add(new Employee("3", "Mila", "female"));
		
		List<Employee> li = list.stream().filter(n -> n.getId().equals(id)).collect(Collectors.toList());
		
		if(li.size() == 0) throw new EmployeeNotFoundException();
		
		return li.get(0).getName();
	}
	
}
