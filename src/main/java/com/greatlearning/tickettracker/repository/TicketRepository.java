package com.greatlearning.tickettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.tickettracker.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
