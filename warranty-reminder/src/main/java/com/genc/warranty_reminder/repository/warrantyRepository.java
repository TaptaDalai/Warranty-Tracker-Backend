package com.genc.warranty_reminder.repository;

import com.genc.warranty_reminder.model.warrantyData;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface warrantyRepository extends MongoRepository<warrantyData,String> {
}
