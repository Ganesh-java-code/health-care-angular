package in.nit.ganesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.ganesh.entity.Specialization;
import in.nit.ganesh.exception.SpecializationException;
import in.nit.ganesh.service.SpecializationService;

@RestController
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private SpecializationService service;
	
	@GetMapping("/show")
	public ResponseEntity<String> saveSpecialization(@RequestBody Specialization specialization){
		ResponseEntity<String> resp = null;
		Integer id = service.saveSpecialization(specialization);
		resp = new ResponseEntity<String>(HttpStatus.CREATED);
		return resp;
	}
}
