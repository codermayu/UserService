package com.example.userservice.dtos;

import lombok.Data;

@Data
public class SendEmailDTO {

   private String subject;
   private String body;
   private String toEmail;
   private String toName;
}
