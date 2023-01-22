package com.greatlearning.tickettracker.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tickets")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private int id;

	@Column(name = "ticket_title")
	private String title;

	@Column(name = "ticket_short_description")
	private String shortDescription;

	@Column(name = "ticket_content")
	private String content;

	@CreatedDate
	@Column(name = "ticket_creation_date")
	private Date dateOfCreation;

}
