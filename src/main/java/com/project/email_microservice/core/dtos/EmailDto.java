package com.project.email_microservice.core.dtos;

public record EmailDto(
        String userId,
        String emailTo,
        String emailSubject,
        String emailBody
){};
