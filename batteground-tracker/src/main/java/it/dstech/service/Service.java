package it.dstech.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import it.dstech.model.Composizione;
import it.dstech.model.Eroe;
import it.dstech.model.Partita;
import it.dstech.model.Utente;

public class Service {
	private EntityManager em;

	public Service(EntityManager em) {
		this.em = em;
	}

	public boolean checkEsistenzaUtente(String username, String password) {
		Utente utente = em.find(Utente.class, username);
		if (utente.getPassword().equals(password) && utente.getUsername().equals(username)) {
			return true;

		}

		return false;
	}

	public void creazioneUtente(String username, String password) {
		Utente utente = new Utente();

		utente.setUsername(username);
		utente.setPassword(password);
		utente.setRuolo("cliente");
				

		em.getTransaction().begin();
		em.persist(utente);
		em.getTransaction().commit();
	}
	public boolean checkRegistrazione(String username) {
		if(em.find(Utente.class, username) != null) {
			return true;
			
		}return false;
	
	}
	public List<Eroe> stampaListaEroi(){
		TypedQuery<Eroe> query=em.createQuery("select e from Eroe e;",Eroe.class);
		 return query.getResultList();
		
		
		
	}
	public List<Composizione> stampaListaComposizioni(){
		TypedQuery<Composizione> query=em.createQuery("select c from Composizione c;",Composizione.class);
		 return query.getResultList();
		
	}
	public void aggiungiPartita(String composition, String eroe, String note) {
		Partita partita = new Partita();

		partita.setComposition(composition);
		partita.setEroe(eroe);
		partita.setNote(note);
		
		em.getTransaction().begin();
		em.persist(partita);
		em.getTransaction().commit();
	}
}
