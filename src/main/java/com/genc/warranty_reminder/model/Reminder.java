package com.genc.warranty_reminder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reminder {
    private String productName;
    private String message;
    private String status;
    private LocalDate reminderDate;
}
