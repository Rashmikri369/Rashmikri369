package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User.java
 * This is a model class represents a Flights entity
 * @author Bala
 *
 */

@Entity
@Table(name="flightdetails")
public class Flights {
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="id")
 protected int id;
 
 @Column(name="flight")
 protected String flight;

 @Column(name="source")
 protected String source;

 @Column(name="destination")
 protected String destination;
 
 @Column(name="date")
 protected Date date;
 
 @Column(name="ticketprice")
 protected int ticketprice;
 
 public Flights() {
 }
 
 public Flights(String flight, String source, String destination, Date date, int ticketprice) {
  super();
	 System.out.println("inside flight update");
  this.flight = flight;
  this.source = source;
  this.destination = destination;
  this.date = date;
  this.ticketprice = ticketprice;
 }

 public Flights(int id, String flight, String source, String destination, Date date, int ticketprice) {
	  super();
	  this.id = id;
	  this.flight = flight;
	  this.source = source;
	  this.destination = destination;
	  this.date = date;
	  this.ticketprice = ticketprice;
	 }

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFlight() {
		return flight;
	}
	
	public void setFlight(String flight) {
		this.flight = flight;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getTicketprice() {
		return ticketprice;
	}
	
	public void setTicketprice(int ticketprice) {
		this.ticketprice = ticketprice;
	}
}
