package com.java.Travel.service.ServiceImpl;


import com.java.Travel.config.EmailConfig;

import com.java.Travel.controller.dto.IncidentDTO;
import com.java.Travel.service.EmailSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender {

    private final static Logger LOGGER = LogManager.getLogger();

    private final String APP_MAIL = "Travelautosender@gmail.com";

    private EmailConfig emailConfig;
    private JavaMailSenderImpl mailSender;

    @Autowired
    public EmailSenderImpl(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
        this.mailSender = new JavaMailSenderImpl();

        mailSender.setHost(this.emailConfig.getHost());
        mailSender.setPort(this.emailConfig.getPort());
        mailSender.setUsername(this.emailConfig.getUsername());
        mailSender.setPassword(this.emailConfig.getPassword());
    }

    @Override
    public void sendСonfirmPurchaseToEmail(IncidentDTO incidentDTO) {
        LOGGER.info("Send confirm purchase to email: " + incidentDTO.getUserDTO().getEmail() + ". Order: " + incidentDTO);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(APP_MAIL);
        mailMessage.setTo(incidentDTO.getUserDTO().getEmail());
        mailMessage.setSubject("Your tickets purchase Order #" + incidentDTO.getId() + " on Travel.by");
        mailMessage.setText("Hello, Dear friend.\n" +
                "Your Order #" + incidentDTO.getId() + " has been successfully paid.\n" +
                "User: " + incidentDTO.getUserDTO().getLogin() + '\n' +
                "Telephone: " + incidentDTO.getUserDTO().getPhoneNumber() + '\n' +
                "\n\n\n\n" +
                "Printing tickets in the infokiosk by order number." + '\n' +
                "-------------------------------------------------------------------\n" +
                "This message was automatically generated. Please do not reply to this message.");

        mailSender.send(mailMessage);
    }

    @Override
    public void sendСancellationСonfirmToEmail(IncidentDTO incidentDTO) {
        LOGGER.info("Send cancellation confirm  to email: " + incidentDTO.getUserDTO().getEmail() + ". Incident: " + incidentDTO);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(APP_MAIL);
        mailMessage.setTo(incidentDTO.getUserDTO().getEmail());
        mailMessage.setSubject("Your  Order #" + incidentDTO.getId() + " on Travel.by has been canceled");
        mailMessage.setText("Hello, Dear friend.\n" +
                "Your Order #" + incidentDTO.getId() + " has been canceled.\n"  +
                "-------------------------------------------------------------------\n" +
                "This message was automatically generated. Please do not reply to this message.");

        mailSender.send(mailMessage);
    }
}
