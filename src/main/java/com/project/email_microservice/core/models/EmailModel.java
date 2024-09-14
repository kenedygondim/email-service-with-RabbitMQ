package com.project.email_microservice.core.models;

import com.project.email_microservice.core.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "TB_EMAILS")
@Getter
@Setter
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "email_from")
    private String emailFrom;
    @Column(name = "email_to")
    private String emailTo;
    @Column(name = "email_subject")
    private String emailSubject;
    @Column(columnDefinition = "TEXT", name = "email_body")
    private String emailBody;
    @Column(name = "send_datetime_email")
    private OffsetDateTime sendDateTimeEmail;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_email")
    private StatusEmail statusEmail;
}
