package com.greatlearning.tta.service;

import java.util.List;

import com.greatlearning.tta.entity.Ticket;

public interface TicketService {

	List<Ticket> getAllTickets();

	Ticket saveTicket(Ticket ticket);

	Ticket getTicketById(Long id);

	Ticket updateTicket(Ticket ticket);

	void deleteTicketById(Long id);

	List<Ticket> searchTicket(String keyword);

}
