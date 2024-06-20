package com.genc.warranty_reminder.api;


import
        com.genc.warranty_reminder.DTO.WarrantyCreateResponse;

import com.genc.warranty_reminder.model.WarrantyData;

import com.genc.warranty_reminder.service.WarrantyService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WarrantyController {

    private final WarrantyService warrantyService;

    @GetMapping("/check")
    String anyMethod()
    {
        return "Hello Young Experts";
    }
    @PostMapping(path="/warranty",consumes= MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<WarrantyCreateResponse>requestToCreateWarranty(@RequestBody WarrantyData warrantyData)
{
    return new ResponseEntity<>(warrantyService.addWarranty(warrantyData), HttpStatus.OK);
}





}
