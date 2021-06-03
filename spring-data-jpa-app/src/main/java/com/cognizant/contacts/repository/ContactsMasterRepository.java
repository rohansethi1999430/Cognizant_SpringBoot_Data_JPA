package com.cognizant.contacts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.contacts.entity.ContactsMasterEntity;

@Repository //optional
public interface ContactsMasterRepository extends CrudRepository<ContactsMasterEntity, Integer> {
	
}
