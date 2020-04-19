package it.dstech.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.http.Part;

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
	
/////////////Aggiunta
	public void creazioneUtente(String username, String password, long rating) {
		Utente utente = new Utente();
		utente.setUsername(username);
		utente.setPassword(password);
		utente.setRuolo("cliente");
		utente.setRating(rating);
		em.getTransaction().begin();
		em.persist(utente);
		em.getTransaction().commit();
	}
	
	public void aggiungiPartita(String username, String composition, String eroe, String note, int punteggio, int posizione) {
		Partita partita = new Partita();
		partita.setUsernameUtente(username);
		partita.setComposition(composition);
		partita.setEroe(eroe);
		partita.setNote(note);
		partita.setPosizione(posizione);
		partita.setPunteggio(punteggio);
		em.getTransaction().begin();
		em.persist(partita);
		em.getTransaction().commit();
	}
	public void aggiungiEroe(String nome, Part immagine, String heroPower) throws IOException {
		InputStream f = immagine.getInputStream();
		byte[] imageBytes = new byte[(int) immagine.getSize()];
		f.read(imageBytes, 0, imageBytes.length);
		f.close();
		String imageStr = Base64.getEncoder().encodeToString(imageBytes);
		Eroe e = new Eroe();
		e.setNome(nome);
		e.setImage(imageStr);
		e.setHeroPower(heroPower);
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
/////////////Check
	public boolean checkEsistenzaUtente(String username, String password) {
		Utente utente = em.find(Utente.class, username);
		if (utente.getPassword().equals(password) && utente.getUsername().equals(username)) {
			return true;
		}
		return false;
	}
	public boolean checkRegistrazione(String username) {
		if (em.find(Utente.class, username) != null) {
			return true;
		}
		return false;
	}
	
	public boolean checkRuolo(String username) {
		Utente utente = em.find(Utente.class, username);
		if (!"cliente".equals(utente.getRuolo())) {
			return true;
		}
		return false;
	}
	public boolean checkEsistenzaEroe(String nome) {
		Eroe eroe = em.find(Eroe.class, nome);
		if (eroe != null) {
			return true;
		}return false;
	}
/////////////Update
	public void updateRating(String username, long rating) {
		Utente utente = em.find(Utente.class, username);
		utente.setRating(rating);
		em.getTransaction().begin();
		em.merge(utente);
		em.getTransaction().commit();
	}
/////////////Stampa
	public List<Eroe> stampaListaEroi() {
		TypedQuery<Eroe> query = em.createQuery("select e from Eroe e;", Eroe.class);
		return query.getResultList();
	}
	
	public List<Composizione> stampaListaComposizioni() {
		TypedQuery<Composizione> query = em.createQuery("select c from Composizione c;", Composizione.class);
		return query.getResultList();
	}
	
	public List<Partita> stampaListaPartite(String username) {
		TypedQuery<Partita> query = em.createQuery("select p from Partita p where p.usernameUtente = ?1", Partita.class);
		query.setParameter(1, username);
		return query.getResultList();
	}
	public long getRating(String username) {
		Utente utente = em.find(Utente.class, username);
		return utente.getRating();
	}
/////////////Elimina
	public void eliminaEroe(String nome) {
		Query query = em.createQuery("DELETE FROM Eroe e where e.nome = ?1", Eroe.class);
		query.setParameter(1, nome);
	}
	public void eliminaUtente(String username) {
		Query query = em.createQuery("DELETE FROM Utente u where u.username = ?1", Eroe.class);
		query.setParameter(1, username);
	}

}
