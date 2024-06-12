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
public class WarrantyData {

    @Id
    private String id;
    private String userMail;
    private String productName;
    private String brand;
    private String model;
    private LocalDate purchaseDate;
    private Integer warrantyYears;
    private LocalDate expiredDate;
    private MultipartFile productImage;
    private MultipartFile document;
    private String description;
    private String link;
}
