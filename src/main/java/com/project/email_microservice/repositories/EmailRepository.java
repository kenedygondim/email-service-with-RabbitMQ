package com.project.email_microservice.repositories;

import com.project.email_microservice.core.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> { }
