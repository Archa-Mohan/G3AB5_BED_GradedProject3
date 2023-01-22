package com.greatlearning.tickettracker.service;

import java.util.List;

import com.greatlearning.tickettracker.model.Ticket;

public interface TicketService {

	// For viewing all the tickets
	public List<Ticket> getAllTickets();

	// Save or Update ticket details to DB
	public void saveOrUpdate(Ticket ticket);

	// Delete ticket details using ticket_id
	public void deleteTicketeById(int id);

	// Read ticket details from DB using ticket_id
	public Ticket getTicketById(int id);

	// Querying for tickets based on input
	public List<Ticket> getTicketsByQuery(String input_query);
}
