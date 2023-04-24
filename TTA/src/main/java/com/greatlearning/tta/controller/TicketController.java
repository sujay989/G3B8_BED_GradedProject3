package com.greatlearning.tta.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.service.TicketService;

@Controller
public class TicketController {

	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@GetMapping("/tickets")
	public String listTickets(Model model) {
		model.addAttribute("tickets", ticketService.getAllTickets());
		return "tickets";
	}

	@GetMapping("/tickets/newTicket")
	public String createTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("tickets", ticket);
		return "new_ticket";
	}

	@PostMapping("/tickets")
	public String saveTicket(@ModelAttribute("tickets") Ticket ticket) {
		ticketService.saveTicket(ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable Long id) {
		ticketService.deleteTicketById(id);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "edit_ticket";
	}

	@PostMapping("/tickets/{id}")
	public String updateTicket(@PathVariable Long id, @ModelAttribute("ticket") Ticket ticket, Model model) {
		Ticket existingTicket = ticketService.getTicketById(id);
		existingTicket.setId(id);
		existingTicket.setTicketTitle(ticket.getTicketTitle());
		existingTicket.setTicketShortDescription(ticket.getTicketShortDescription());
		existingTicket.setTicketContent(ticket.getTicketContent());

		ticketService.updateTicket(existingTicket);
		return "redirect:/tickets";
	}

	@GetMapping("/search")
	public String searchTicketByTitle(Ticket ticket, Model model, @Param("keyword") String keyword) {
		if (keyword != null) {
			List<Ticket> list = ticketService.searchTicket(keyword);
			if (!list.isEmpty()) {
				model.addAttribute("tickets", list);
				model.addAttribute("keyword", keyword);
				return "search_ticket";
			} else
				return "ticket_notFound";
		} else {
			model.addAttribute("tickets", ticketService.getAllTickets());
			return "tickets";
		}
	}

	@GetMapping("/tickets/view/{id}")
	public String viewTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "view_ticket";
	}

}
