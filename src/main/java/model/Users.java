package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User.java
 * This is a model class represents a Users entity
 * @author Bala
 *
 */

@Entity
@Table(name="users")
public class Users {
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="id")
 protected int id;
 
 @Column(name="name")
 protected String name;
 
 @Column(name="password")
 protected String password;
 
	 public Users() {
	 }
	 
	 public Users(String name, String password) {
	  super();
	  this.name = name;
	  this.password = password;
	 }
	
	 public Users(int id, String name, String password) {
	  super();
	  this.id = id;
	  this.name = name;
	  this.password = password;
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
	 public String getPassword() {
	  return password;
	 }
	 public void setPassword(String password) {
	  this.password = password;
	 }

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
 
 }