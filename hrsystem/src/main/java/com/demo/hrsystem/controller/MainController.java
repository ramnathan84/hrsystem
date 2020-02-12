package com.demo.hrsystem.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.hrsystem.model.Admin;
import com.demo.hrsystem.model.Employee;
import com.demo.hrsystem.payload.ApiResponse;
import com.demo.hrsystem.payload.LoginRequest;
import com.demo.hrsystem.payload.SignUpRequest;
import com.demo.hrsystem.repository.AdminRepository;
import com.demo.hrsystem.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MainController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AdminRepository adminRepository;

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {

		boolean login = false;
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();

		List<Admin> admins = adminRepository.findAll();

		for (Admin admin : admins) {

			if (admin.getName().equalsIgnoreCase(username) && admin.getPassword().equalsIgnoreCase(password)) {
				return new ResponseEntity(new ApiResponse(true, "Successful login!"), HttpStatus.ACCEPTED);
			}

		}

		return new ResponseEntity(new ApiResponse(false, "Login failed!"), HttpStatus.FORBIDDEN);

	}

	@GetMapping("/allEmployees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/allEmployees/{empId}")
	public Employee getEmployeeById(@PathVariable Long empId) {
		return employeeRepository.getOne(empId);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

		Employee emp = new Employee();
		emp.setName(signUpRequest.getName());
		emp.setEmail(signUpRequest.getEmail());
		emp.setMobile(signUpRequest.getMobile());
		emp.setSex(signUpRequest.getSex());
		emp.setAddress(signUpRequest.getAddress());

		Employee result = employeeRepository.save(emp);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/allEmployees/{empId}")
				.buildAndExpand(result.getName()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	}

}
