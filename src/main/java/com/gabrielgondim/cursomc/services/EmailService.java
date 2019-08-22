package com.gabrielgondim.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.gabrielgondim.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
