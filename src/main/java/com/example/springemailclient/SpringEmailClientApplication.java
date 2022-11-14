package com.example.springemailclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailClientApplication {

	private final EmailSenderService emailSenderService;

	public SpringEmailClientApplication(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() throws MessagingException {
//		emailSenderService.sendSimpleEmail("example@gmail.com", "Email body", "Email subject");
		emailSenderService.sendEmailWithFile("example@gmail.com", "body", "subject", "src/main/resources/pfp.jpg");
	}
}
