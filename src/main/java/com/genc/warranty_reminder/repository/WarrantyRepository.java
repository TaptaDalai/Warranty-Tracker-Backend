package com.genc.warranty_reminder.repository;

import com.genc.warranty_reminder.model.WarrantyData;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface WarrantyRepository extends MongoRepository<WarrantyData,String> {
}
