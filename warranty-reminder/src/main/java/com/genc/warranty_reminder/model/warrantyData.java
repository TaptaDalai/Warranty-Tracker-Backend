package com.genc.warranty_reminder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class warrantyData {

    @Id
    private String id;
    private MultipartFile file;
    private String productName;
    private String cost;
    private LocalDate purchaseDate;
    private Integer warrantyYears;
    private String serialNum;
    private String description;
    private String link;
}
