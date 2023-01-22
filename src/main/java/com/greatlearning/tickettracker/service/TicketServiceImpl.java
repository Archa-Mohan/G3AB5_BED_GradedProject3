package com.greatlearning.tickettracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.tickettracker.model.Ticket;
import com.greatlearning.tickettracker.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository repository;

	@Override
	public List<Ticket> getAllTickets() {
		return repository.findAll();
	}

	@Override
	public void saveOrUpdate(Ticket ticket) {
		repository.save(ticket);
	}

	@Override
	public void deleteTicketeById(int id) {
		repository.deleteById(id);
	}

	@Override
	public Ticket getTicketById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Ticket> getTicketsByQuery(String input_query) {
		Ticket ticketSearch = new Ticket();
		ticketSearch.setTitle(input_query);
		ticketSearch.setShortDescription(input_query);
		ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
				.withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("shortDescription", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withIgnorePaths("ticket_id", "ticket_content", "ticket_creation_date");
		Example<Ticket> example = Example.of(ticketSearch, customExampleMatcher);
		System.out.println(customExampleMatcher);
		return repository.findAll(example);
	}

}
