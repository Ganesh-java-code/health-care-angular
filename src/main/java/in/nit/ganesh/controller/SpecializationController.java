package in.nit.ganesh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spec")
public class SpecializationController {

	@GetMapping("/show")
	public String showData() {
		return "Hello world!!!";
	}
	
}
