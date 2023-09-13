package com.project;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.Service;
import com.project.dto.EmployeeUpdateRequest;

@RestController
public class Controller {
	@GetMapping("/check")
	public String check() {
		return "success";
	}

	@Autowired
	private Service service;

	@GetMapping("/getAllEmployeesMySQL")
	public List<Map<String, Object>> getAllEmployeesMySQL() {
		return service.getAllEmployeeDetails();
	}

	/**
	 * @author Shubham Kitukale
	 * @param condition
	 * @param logical_Operator
	 * @return
	 */
	@GetMapping("/getdataMYSQL/condition/{condition}/LogicalOperator/{logical_Operator}")
	public List<Map<String, Object>> getData(@PathVariable String condition, @PathVariable String logical_Operator) {
		return service.getDetailsByIdPass(condition, logical_Operator);
	}

	
/*
	@PostMapping("/postdataMYSQL/firstName/{firstNameIp}")
	public List<Map<String, Object>> postDataToMysqlDb(@PathVariable String firstNameIp) {
		return service.insertEmployeeData(firstNameIp);
	}
	@PutMapping("/updateDataMySQL/{employeeId}")
	public ResponseEntity<String> updateEmployeeMYSQL(@PathVariable int employeeId,
			@RequestBody EmployeeUpdateRequest request) {
		try {
			service.updateEmployee(employeeId, request.getNewFirstName(), request.getNewLastName());
			return ResponseEntity.ok("Employee updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Error updating employee");
		}
	}

	@DeleteMapping("/deleteEmployeeById/{condition}/logical_oprator/{logical_oprator}")
	public ResponseEntity<String> deleteEmployeeMYSQL(@PathVariable String condition,
			@PathVariable String logical_oprator) {
		try {
			service.deleteEmployee(condition, logical_oprator);
			return ResponseEntity.ok("Employee deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Error deleting employee");
		}
	}
*/
}
