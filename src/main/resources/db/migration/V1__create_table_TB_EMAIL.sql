CREATE TABLE TB_EMAILS (
    email_id VARCHAR(36) PRIMARY KEY,
    user_id VARCHAR(36) NOT NULL,
    email_from VARCHAR(70) NOT NULL,
    email_to VARCHAR(70) NOT NULL,
    /*subject é uma palavra reservada do mysql*/
    email_subject VARCHAR(70),
    email_body TEXT NOT NULL,
    send_datetime_email TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ,
    status_email ENUM ('SENT', 'ERROR') NOT NULL
);