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

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WarrantyController {

    private final WarrantyService warrantyService;
    @PostMapping(path = "/warranties/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WarrantyCreateResponse> addWarranty(@RequestBody WarrantyData warrantyData) {
        return new ResponseEntity<>(warrantyService.addWarranty(warrantyData), HttpStatus.CREATED);

    }

    @GetMapping(path = "/allwarranties")
    public ResponseEntity<List<WarrantyData>> getAllWarranties() {
        return new ResponseEntity<>(warrantyService.getAllWarranties(), HttpStatus.OK);
    }

    @GetMapping(path = "/getproduct/{id}")
    public ResponseEntity<WarrantyData> getOneWarranty(@PathVariable String id) {
        return new ResponseEntity<>(warrantyService.getOneWarranty(id), HttpStatus.OK);
    }

    @GetMapping(path = "/products/{userMail}")
    public ResponseEntity<List<WarrantyData>> productListByEmail(@PathVariable String userMail) {
        return new ResponseEntity<>(warrantyService.productList(userMail), HttpStatus.OK);
    }

    @PutMapping(path = "/warranties/update/{id}")
    public ResponseEntity<WarrantyCreateResponse> updateWarranty(@RequestBody WarrantyData warrantyData, @PathVariable String id){
        return new ResponseEntity<>(warrantyService.updateWarranty(warrantyData,id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/warranties/remove/{id}")
    public ResponseEntity<WarrantyCreateResponse> deleteWarranty(@PathVariable String id) {
        return new ResponseEntity<>(warrantyService.deleteWarranty(id), HttpStatus.OK);
    }

}
