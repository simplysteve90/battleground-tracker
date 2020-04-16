package it.dstech.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Partita {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String composition;
	@OneToMany
	private List<Eroe>eroi;
	public Partita() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Eroe> getEroi() {
		return eroi;
	}
	public void setEroi(List<Eroe> eroi) {
		this.eroi = eroi;
	}
	@Override
	public String toString() {
		return "Partita [id=" + id + ", composition=" + composition + ", eroi=" + eroi + "]";
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}

}
