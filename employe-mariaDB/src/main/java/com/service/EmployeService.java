package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employe;
import com.repository.EmployeRepository;

@Service
public class EmployeService {

	@Autowired
	EmployeRepository employeRepository;
	
	public Map<String, Object> insertEmployeData(Employe employe) {
		Map<String, Object> response = new HashMap();
		employeRepository.save(employe);
		response.put("message", "inserted successfully");
		return response;
	}

	public Map<String, Object> updateEmployeDetailsById(Employe employe) {
		Employe oldEmploye=null;
		Map<String, Object> response = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Optional<Employe> optionalUser=employeRepository.findById(employe.getEmpId());
		if(optionalUser.isPresent()) {
			oldEmploye=optionalUser.get();
			oldEmploye.setEmpName(employe.getEmpName());
			oldEmploye.setDesignation(employe.getDesignation());
			oldEmploye.setAddress(employe.getAddress());
			employeRepository.save(oldEmploye);
			result.put("message", "Updated Successfully");
		}
		else {
			response.put("message", "No record found");
		}
		return result;
	}

	public Map<String, Object> deleteEmployeById(int id) {
		Map<String, Object> response = new HashMap<String, Object>();
		employeRepository.deleteById(id);
		response.put("message", "deleted successfully");
		return response;
	}

	public List<Employe> getEmployeData() {
		List result = null;
		result=employeRepository.findAll();
		return result;
	}

	

}
