package com.genc.warranty_reminder.repository;

import com.genc.warranty_reminder.model.UserAuthenticationData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthenticationRepository extends MongoRepository<UserAuthenticationData,String> {
    List<UserAuthenticationData> findByEmail(String email);
}
