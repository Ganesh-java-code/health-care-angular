package in.nit.ganesh.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	//create/save record using postMapping http method call
	@PostMapping("/create")
	public ResponseEntity<String> saveSpecialization(@RequestBody Specialization specialization) {
		//creating response entity object
		ResponseEntity<String> resp = null;
		Integer id = service.saveSpecialization(specialization);
		String msg = "Spec'" + id + "'created..";
		resp = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return resp;
	}

	//fetch all record using getmapping http method call
	@GetMapping("/all")
	public ResponseEntity<?> getAllSpecialization() {
		ResponseEntity<?> resp = null;
		List<Specialization> list = service.getAllSpecializations();
		if (list.isEmpty()) {
			throw new SpecializationException("No Record found..");
		}
		resp = new ResponseEntity<List<Specialization>>(list, HttpStatus.OK);
	return resp;

	}

	//fetch one record using getmapping http method call
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneSpec(@PathVariable Integer id){
		ResponseEntity<?> resp = null;
		try {
			Specialization specialization = service.getOneSpecialization(id);
			resp = new ResponseEntity<Specialization>(specialization,HttpStatus.OK);
		} catch (SpecializationException se) {
			se.printStackTrace();
			String message = "No Record found";
			resp = new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	//Delete Records Rest call using http method call
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteSpec(@PathVariable Integer id){
		ResponseEntity<String> resp = null;
		String message = null;
		try {
			service.deleteSpecialization(id);
			message = "Spec deleted..";
			resp = new ResponseEntity<String>(message,HttpStatus.OK);
		} catch (SpecializationException se) {
			message = "No Record found for delete";
			resp = new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	//update function call using http method call putmapping
	@PutMapping("/modify")
	public ResponseEntity<String> updateSpec(@RequestBody Specialization specialization){
		ResponseEntity<String> resp = null;
		try {
			service.updateSpecialization(specialization);
			resp = new ResponseEntity<String>("Spec Updated Successfully..",HttpStatus.OK);
		} catch (SpecializationException se) {
			String message = "Not Updated..";
			resp = new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
}