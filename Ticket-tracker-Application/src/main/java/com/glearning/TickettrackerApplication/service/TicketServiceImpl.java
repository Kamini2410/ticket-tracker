package com.glearning.TickettrackerApplication.service;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.TickettrackerApplication.model.Ticket;
import com.glearning.TickettrackerApplication.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private final TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public Ticket createTicket(String title, String description, String status) {
		Ticket ticket = new Ticket(title, description, status);
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		java.util.Optional<Ticket> optionalTicket = ticketRepository.findById(id);
		return optionalTicket.orElse(null);
	}

	@Override
	public Ticket updateTicket(Long id, String title, String description, String status) {
		java.util.Optional<Ticket> optionalTicket = ticketRepository.findById(id);
		if (optionalTicket.isPresent()) {
			Ticket ticket = optionalTicket.get();
			ticket.setTitle(title);
			ticket.setDescription(description);
			ticket.setStatus(status);
			return ticketRepository.save(ticket);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteTicket(Long id) {
		java.util.Optional<Ticket> optionalTicket = ticketRepository.findById(id);
		if (optionalTicket.isPresent()) {
			ticketRepository.delete(optionalTicket.get());
			return true;
		} else {
			return false;
		}
	}
}