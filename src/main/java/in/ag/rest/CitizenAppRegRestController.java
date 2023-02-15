package in.ag.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ag.binding.CitizenApp;
import in.ag.service.CitizenAppRegService;

@RestController
public class CitizenAppRegRestController {
	
	@Autowired
	private CitizenAppRegService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCitizen(@RequestBody CitizenApp app){
		
		String response = service.registerCitizenApp(app);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

}
