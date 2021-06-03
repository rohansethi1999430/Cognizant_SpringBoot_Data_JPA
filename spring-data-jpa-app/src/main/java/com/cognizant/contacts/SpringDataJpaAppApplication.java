package com.cognizant.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.contacts.entity.ContactsMasterEntity;
import com.cognizant.contacts.repository.ContactsMasterRepository;

@SpringBootApplication
public class SpringDataJpaAppApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpaAppApplication.class, args);
		
		ContactsMasterRepository cmRepo = context.getBean(ContactsMasterRepository.class);
		
		ContactsMasterEntity entity = new ContactsMasterEntity();
		entity.setContactId(101);
		entity.setContactName("Aniket Das");
		entity.setContactNumber("9876543210");
		
		ContactsMasterEntity savedEntity = cmRepo.save(entity);
		
		context.close();
	}
}
