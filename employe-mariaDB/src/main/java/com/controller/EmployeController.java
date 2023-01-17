package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employe;
import com.service.EmployeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeController {

	@Autowired
	EmployeService employeService;
	
	@PostMapping("/employe")
	public Map<String,Object> insertEmployeData(@RequestBody Employe employe)
	{
		return employeService.insertEmployeData(employe);
	}
	
	@DeleteMapping("/deleteEmployeById/{id}")
	public Map<String,Object> deleteEmployeById(@PathVariable int id)
	{
		return employeService.deleteEmployeById(id);
	}
	
	@PutMapping("/updateEmployeDetailsById")
	public Map<String,Object> updateEmployeDetailsById(@RequestBody Employe employe) {
		return employeService.updateEmployeDetailsById(employe);
	}
	
	@GetMapping("/getEmployeData")
	public List<Employe> getEmployeData(){
		return employeService.getEmployeData();
	}
}
