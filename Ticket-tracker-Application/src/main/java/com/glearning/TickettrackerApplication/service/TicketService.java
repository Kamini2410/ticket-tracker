package com.glearning.TickettrackerApplication.service;

import com.glearning.TickettrackerApplication.model.Ticket;

public interface TicketService {
	Ticket createTicket(String title, String description, String status);

	Ticket getTicketById(Long id);

	Ticket updateTicket(Long id, String title, String description, String status);

	boolean deleteTicket(Long id);
}