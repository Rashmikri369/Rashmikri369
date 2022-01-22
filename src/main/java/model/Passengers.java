package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Bala
 *
 */

@Entity
@Table(name="passengerdetails")
public class Passengers {
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="id")
 protected int id;
 
 @Column(name="name")
 protected String name;
 
 @Column(name="email")
 protected String email;
 
 @Column(name="country")
 protected String country;
 
 @Column(name="fid")
 protected int fid;
 
 @Column(name="sid")
 protected String sid;

 @Column(name="pnr")
 protected String pnr;
 
 
 public Passengers() {
 }
 
 public Passengers(String name, String email, String country, int fid, String sid, String pnr) {
  super();
  this.name = name;
  this.email = email;
  this.country = country;
  this.fid = fid;
  this.sid = sid;
  this.pnr = pnr;
 }

 public Passengers(int id, String name, String email, String country, int fid, String sid, String pnr) {
  super();
  this.id = id;
  this.name = name;
  this.email = email;
  this.country = country;
  this.fid = fid;
  this.sid = sid;
  this.pnr = pnr;
 }

 public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public String getEmail() {
  return email;
 }
 public void setEmail(String email) {
  this.email = email;
 }
 public String getCountry() {
  return country;
 }
 public void setCountry(String country) {
  this.country = country;
 }
 public int getFid() {
	 return fid;
 }
 public void setFid(int fid) {
	 this.fid = fid;
 }
 public String getSid() {
	 return sid;
 }
 public void setSid(String sid) {
	 this.sid = sid;
 }
 public String getPnr() {
	 return pnr;
 }
 public void setPnr(String pnr) {
	 this.pnr = pnr;
 }
}