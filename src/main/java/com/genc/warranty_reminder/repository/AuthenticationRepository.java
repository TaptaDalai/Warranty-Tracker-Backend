package com.genc.warranty_reminder.repository;

import com.genc.warranty_reminder.model.UserAuthenticationData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthenticationRepository extends MongoRepository<UserAuthenticationData,String> {
}
