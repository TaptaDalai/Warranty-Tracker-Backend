package com.genc.warranty_reminder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthenticationData {
    @Id
    private String id;
    private String fullName;
    private String email;
    private String password;
    private String role;

}
