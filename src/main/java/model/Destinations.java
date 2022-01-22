package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Destinations.java
 * This is a model class represents a destinations entity
 * @author Balanarenthiran
 *
 */

@Entity
@Table(name="destinations")
public class Destinations {

 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="id")
 protected int id;
 
 @Column(name="destination")
 protected String destination;
 
 
	 public Destinations() {
	 }
	 
	 public Destinations(String destination) {
	  super();
	  this.destination = destination;
	 }
	
	 public Destinations(int id, String destination) {
	  super();
	  this.id = id;
	  this.destination = destination;
	 }

	 public int getId() {
	  return id;
	 }
	 public void setId(int id) {
	  this.id = id;
	 }

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Destinations [id=" + id + ", destination=" + destination + "]";
	}
 
 }