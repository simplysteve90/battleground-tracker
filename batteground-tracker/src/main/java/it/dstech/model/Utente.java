package it.dstech.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utente {
	@Id
	private String username;
	private String email;
	private String password;
	private String ruolo;
	private long ratingIniziale;
	private long rating;
	@Column(columnDefinition = "BOOLEAN NOT NULL")
	private boolean active;
	 @OneToMany
	 private List<Partita>partite;
	public Utente() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Partita> getPartite() {
		return partite;
	}
	public void setPartite(List<Partita> partite) {
		this.partite = partite;
	}
	@Override
	public String toString() {
		return "Utente [username=" + username + ", password=" + password + ", partite=" + partite + "]";
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRating(long rating) {
		this.rating = rating;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public long getRatingIniziale() {
		return ratingIniziale;
	}
	public void setRatingIniziale(long ratingIniziale) {
		this.ratingIniziale = ratingIniziale;
	}

}
