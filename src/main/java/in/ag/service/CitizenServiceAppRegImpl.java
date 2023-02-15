package in.ag.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import in.ag.binding.CitizenApp;
import in.ag.entity.CitizenAppEntity;
import in.ag.repository.CitizenAppRepo;

public class CitizenServiceAppRegImpl implements CitizenAppRegService {
	
	@Autowired
	private CitizenAppRepo citizenAppRepo;
	
	//we should not hardcore url here. we should configure in Yaml file.
	
	private static final String REST_URL = "http://ssawebapi-env.eba-k88bsahp.ap-south-1.elasticbeanstalk.com/ssn/%7Bssn%7D";

	@Override
	public String registerCitizenApp(CitizenApp app) {
		
		Long ssn = app.getSsn();
		WebClient webClient = WebClient.create();
		
		String stateName = webClient.get() // start building http GET request
		         .uri(REST_URL, ssn)// specify url to hit
		         .retrieve() // extract response
		         .bodyToMono(String.class) // bind response
		         .block();  // sync call
		
		if("RhodeIsland".equals(stateName)) {
			
			// insert record into db table
			
			CitizenAppEntity entity = new CitizenAppEntity();
			
			// we are getting data in form of binding obj but we need to save in form of entity. that's why we will 
			// copy from BeanUtils
			BeanUtils.copyProperties(app, entity);
			
			 entity = citizenAppRepo.save(entity);
			
			return "Citizen App Created, App ID : " + entity.getAppId();
		}
		return "Citizen not belong to RI...";
	}

}
