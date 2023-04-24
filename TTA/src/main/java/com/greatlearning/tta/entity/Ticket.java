package com.greatlearning.tta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	@Column(name = "ticketTitle", nullable = false)
	private String ticketTitle;

	@Column(name = "ticketShortDescription")
	private String ticketShortDescription;

	@Column(name = "ticketContent")
	private String ticketContent;

	@Column(name = "ticketCreatedOn", nullable = false)
	private String ticketCreatedOn;

	public Ticket() {

	}

	public Ticket(String title, String shortDescription, String content, String createdOn) {
		this.ticketTitle = title;
		this.ticketShortDescription = shortDescription;
		this.ticketContent = content;
		this.ticketCreatedOn = createdOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}

	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	public String getTicketShortDescription() {
		return ticketShortDescription;
	}

	public void setTicketShortDescription(String ticketShortDescription) {
		this.ticketShortDescription = ticketShortDescription;
	}

	public String getTicketContent() {
		return ticketContent;
	}

	public void setTicketContent(String ticketContent) {
		this.ticketContent = ticketContent;
	}

	public String getTicketCreatedOn() {
		return ticketCreatedOn;
	}

	public void setTicketCreatedOn(String ticketCreatedOn) {
		this.ticketCreatedOn = ticketCreatedOn;
	}

	@Override
	public String toString() {
		return "Ticket [ticketTitle=" + ticketTitle + ", ticketShortDescription=" + ticketShortDescription
				+ ", ticketContent=" + ticketContent + ", ticketCreatedOn=" + ticketCreatedOn + "]";
	}

}
