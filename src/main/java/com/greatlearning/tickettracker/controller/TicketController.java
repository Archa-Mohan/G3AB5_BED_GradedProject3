package com.greatlearning.tickettracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.tickettracker.model.Ticket;
import com.greatlearning.tickettracker.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	TicketService service;

	@GetMapping("/")
	public String getAllTickets(Model model) {
		List<Ticket> results = service.getAllTickets();
		model.addAttribute("tickets", results);
		return "tickets";
	}

	@GetMapping("/newTickets")
	public String addNewTicket(Model model) {
		Ticket result = new Ticket();
		model.addAttribute("ticket", result);
		return "create_ticket";
	}

	@GetMapping("/{id}/edit")
	public String updateEmployee(Model model, @PathVariable("id") int id) {
		Ticket result = service.getTicketById(id);
		model.addAttribute("ticket", result);
		return "edit_ticket";
	}

	@GetMapping("/{id}/delete")
	public String deleteTicket(Model model, @PathVariable("id") int id) {
		service.deleteTicketeById(id);
		return "redirect:/";
	}

	@GetMapping("/{id}/view")
	public String viewTicket(Model model, @PathVariable("id") int id) {
		Ticket result = service.getTicketById(id);
		model.addAttribute("ticket", result);
		return "view_ticket";
	}

	@GetMapping("/search")
	public String getTicketByQuery(@RequestParam String query, Model model) {
		List<Ticket> result = service.getTicketsByQuery(query);
		model.addAttribute("listTicket", result);
		System.out.println(result);
		return "search_ticket";
	}

	@PostMapping("/")
	public String saveNewTicket(@ModelAttribute("ticket") Ticket ticket) {
		service.saveOrUpdate(ticket);
		return "redirect:/";
	}

	@PostMapping("/{id}/edit")
	public String saveNewTicket(@ModelAttribute("ticket") Ticket ticket, @PathVariable("id") int id) {
		Ticket exisitingTicket = service.getTicketById(id);
		exisitingTicket.setTitle(ticket.getTitle());
		exisitingTicket.setShortDescription(ticket.getShortDescription());
		exisitingTicket.setContent(ticket.getContent());
		service.saveOrUpdate(exisitingTicket);
		return "redirect:/";
	}

}
