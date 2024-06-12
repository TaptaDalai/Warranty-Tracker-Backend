package com.genc.warranty_reminder.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogInResponse {
   private Boolean allowed;
   private String fullName;
    private String response;
}
