package it.dstech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Partita {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String usernameUtente;
	private String composition;
	private String eroe;
	private String note;
	private int posizione;
	private int punteggio;
	public Partita() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}
	public String getEroe() {
		return eroe;
	}
	public void setEroe(String eroe) {
		this.eroe = eroe;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getPosizione() {
		return posizione;
	}
	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	public String getUsernameUtente() {
		return usernameUtente;
	}
	public void setUsernameUtente(String usernameUtente) {
		this.usernameUtente = usernameUtente;
	}
	@Override
	public String toString() {
		return "Partita [id=" + id + ", composition=" + composition + ", eroe=" + eroe + ", note=" + note
				+ ", posizione=" + posizione + ", punteggio=" + punteggio + "]";
	}
	
	
}