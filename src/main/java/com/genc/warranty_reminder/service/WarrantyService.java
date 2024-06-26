package com.genc.warranty_reminder.service;

import com.genc.warranty_reminder.DTO.WarrantyCreateResponse;
import com.genc.warranty_reminder.model.WarrantyData;
import com.genc.warranty_reminder.repository.WarrantyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class WarrantyService {
    private final WarrantyRepository warrantyRepository;

    //add a new warranty
    public WarrantyCreateResponse addWarranty(WarrantyData warrantyData) {
        this.warrantyRepository.save(warrantyData);
        return WarrantyCreateResponse.builder().id(warrantyData.getId()).response("Good Job! Warranty data of " + warrantyData.getProductName() + " has been Created Successfully").build();
    }

    //get all warranties
    public List<WarrantyData> getAllWarranties() {
        return warrantyRepository.findAll();
    }

    //get one warranty by id
    public WarrantyData getOneWarranty(String id) {
        Optional<WarrantyData> product = this.warrantyRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new Error("product was not found");
        }
    }

    //get warranties by email
    public List<WarrantyData> productList(String email )
    {
        List<WarrantyData>list=this.warrantyRepository.findAll();
        List<WarrantyData>warrantyList=new ArrayList<>();
        for(WarrantyData data:list)
        {
            log.info("enter for loop");

            if(data.getUserMail().equals(email))
            {
                log.info("enter if condition");
                warrantyList.add(data);
            }

        }
        return warrantyList;

    }

    //update warranty
    public WarrantyCreateResponse updateWarranty(WarrantyData warrantyData, String id){
            this.warrantyRepository.save(warrantyData);
            return WarrantyCreateResponse.builder().id(warrantyData.getId()).response("Warranty data of " + warrantyData.getProductName() + " has been Updated Successfully").build();
    }

    //delete warranty by id
    public WarrantyCreateResponse deleteWarranty(String id){
        warrantyRepository.deleteById(id);
        return WarrantyCreateResponse.builder().id(id).response("Warranty data has been Deleted Successfully").build();
    }

}
