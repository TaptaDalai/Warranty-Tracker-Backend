package com.genc.warranty_reminder.service;

import com.genc.warranty_reminder.DTO.WarrantyCreateResponse;
import com.genc.warranty_reminder.model.WarrantyData;
import com.genc.warranty_reminder.repository.WarrantyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarrantyService {
    private final WarrantyRepository warrantyRepository;
    public WarrantyCreateResponse addWarranty(WarrantyData warrantyData)
    {
        this.warrantyRepository.save(warrantyData);
        return WarrantyCreateResponse.builder().id(warrantyData.getId()).response("Good Job Warranty data of "+warrantyData.getProductName()+" has been Created Successfully").build();
    }

    public WarrantyData getOneWarranty(String id)
    {
        Optional<WarrantyData> product=this.warrantyRepository.findById(id);
        if(product.isPresent())
        {
            return product.get();
        }
        else {
            throw new Error("product was not found");
        }
    }
    public List<WarrantyData> productList(String email )
    {
        List<WarrantyData>list=this.warrantyRepository.findAll();
        List<WarrantyData>warrantyList=new ArrayList<>();
        for(WarrantyData data:list)
        {
            if(data.getUserMail()==email)
            {
                warrantyList.add(data);
            }

        }
        return warrantyList;

    }





}
