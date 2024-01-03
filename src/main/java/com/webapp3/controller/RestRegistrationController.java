package com.webapp3.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp3.dto.ReadRegistrationDto;
import com.webapp3.dto.RegistrationDto;
import com.webapp3.entity.Registration;
import com.webapp3.exception.ResourceNotFoundException;
import com.webapp3.repository.RegistrationRepository;

@RestController
@RequestMapping("/api/registrations")
public class RestRegistrationController {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	
	@GetMapping
	public ResponseEntity<ReadRegistrationDto> getAllRegistration(){
		List<Registration> registration = registrationRepository.findAll();
		ReadRegistrationDto dto = new ReadRegistrationDto();
		dto.setRegistrations(registration);
		dto.setMessage("Reading completed!!");
		return new ResponseEntity<>(dto , HttpStatus.OK);
	}
	
	//http://localhost:8080/api/registrations/idnumber
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable long id) {
		
		Optional<Registration> findById = registrationRepository.findById(id); 			   // step for exception handle
		if(findById.isPresent()) {											   			   // step for exception handle
			registrationRepository.deleteById(id);							  			   // step for exception handle
		}else {
			throw new ResourceNotFoundException("Registration not found with id: " + id);  // step for exception handle
		}
		
		return new ResponseEntity<>("record is deleted!!" , HttpStatus.OK);
	}
	
	//save registration
	//http://localhost:8080:/api/registrations
	@PostMapping
	public ResponseEntity<?> saveRegistrations(@Valid @RequestBody Registration reg , BindingResult result) {
		
		if(result.hasErrors()) {
			return new ResponseEntity<>(result.getFieldError().getDefaultMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 Registration saveReg= registrationRepository.save(reg);
		 RegistrationDto dto = new RegistrationDto();
		 dto.setFirstName(saveReg.getFirstName());
		 dto.setEmail(saveReg.getEmail());
		 dto.setMobile(saveReg.getMobile());
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}
	
	
	//update registration
	//http://localhost:8080:/api/registrations?id=8
//	@PutMapping
//	public ResponseEntity<Registration> updateRegistration(@RequestParam long id , @RequestBody RegistrationDto registrationDto) {
//		Registration registration = registrationRepository.findById(id).get();
//		registration.setFirstName(registrationDto.getFirstName());
//		registration.setLastName(registrationDto.getLastName());
//		registration.setEmail(registration.getEmail());
//		registration.setMobile(registrationDto.getMobile());
//		
//		 Registration updateReg= registrationRepository.save(registration);
//		
//		return new ResponseEntity<>(updateReg , HttpStatus.OK);
//	}

}
