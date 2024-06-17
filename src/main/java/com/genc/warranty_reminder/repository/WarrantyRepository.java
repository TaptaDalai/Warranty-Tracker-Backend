package com.genc.warranty_reminder.repository;

import com.genc.warranty_reminder.model.WarrantyData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface WarrantyRepository extends MongoRepository<WarrantyData,String> {
    List<WarrantyData> findByUserMail(String userMail);
}
