package com.greatlearning.tta.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.repository.TicketRepository;
import com.greatlearning.tta.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepo;

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepo.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		Ticket customTicket = new Ticket();
		customTicket.setTicketTitle(ticket.getTicketTitle());
		customTicket.setTicketShortDescription(ticket.getTicketShortDescription());
		customTicket.setTicketContent(ticket.getTicketContent());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
		LocalDate today = LocalDate.now();
		customTicket.setTicketCreatedOn(today.format(formatter));
		return ticketRepo.save(customTicket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepo.findById(id).get();
	}

	@Override
	public void deleteTicketById(Long id) {
		ticketRepo.deleteById(id);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	@Override
	public List<Ticket> searchTicket(String keyword) {
		return ticketRepo.findByTicketTitle(keyword);
	}

}
