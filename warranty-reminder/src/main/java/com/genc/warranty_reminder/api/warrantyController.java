package com.genc.warranty_reminder.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class warrantyController {
    @GetMapping
    String anyMethod()
    {
        return "Hello Tapta";
    }

}
