package it.dstech.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.Part;

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
	public void aggiungiComposizione(String nome) {
		Composizione comp = new Composizione();
		comp.setNome(nome);
		em.getTransaction().begin();
		em.persist(comp);
		em.getTransaction().commit();
	}

	public void creazioneUtente(String username, String email, String password, long rating) {
		Utente utente = new Utente();
		utente.setUsername(username);
		utente.setEmail(email);
		utente.setPassword(password);
		utente.setRuolo("cliente");
		utente.setActive(false);
		utente.setRating(rating);
		em.getTransaction().begin();
		em.persist(utente);
		em.getTransaction().commit();
	}

	public void aggiungiPartita(String username, String composition, String eroe, String note, int punteggio,
			int posizione) {
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

	public void aggiungiEroe(String nome, Part immagine, String heroPower, String costo, String descrizione) throws IOException {
		InputStream f = immagine.getInputStream();
		byte[] imageBytes = new byte[(int) immagine.getSize()];
		f.read(imageBytes, 0, imageBytes.length);
		f.close();
		String imageStr = Base64.getEncoder().encodeToString(imageBytes);
		Eroe e = new Eroe();
		e.setNome(nome);
		e.setImage(imageStr);
		e.setHeroPower(heroPower);
		e.setCosto(costo);
		e.setDescrizione(descrizione);
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}

/////////////Check
	public boolean checkActiveMail(String username) {
		Utente utente = em.find(Utente.class, username);
		if (utente.isActive()) {
			return true;
		}
		return false;
	}

	public boolean checkEstistenzaEmail(String email, String username) {
		Utente utente = em.find(Utente.class, username);
		if (utente != null && utente.getEmail().equals(email)) {
			return true;
		}
		return false;
	}

	public boolean checkEsistenzaComposizione(String nome) {
		Composizione comp = em.find(Composizione.class, nome);
		if (comp != null) {
			return true;
		}
		return false;

	}

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
		}
		return false;
	}

/////////////Update
	public void updateComposizioneEroe(String nome, String composizione) {
		if(composizione != null) {
			Composizione comp = em.find(Composizione.class, nome);
			comp.setNome(composizione);;
			em.getTransaction().begin();
			em.persist(comp);
			em.getTransaction().commit();
		}
	}
	public void updatePowerEroe(String nome, String power) {
		if(power != null) {
			Eroe eroe = em.find(Eroe.class, nome);
			eroe.setHeroPower(power);
			em.getTransaction().begin();
			em.persist(eroe);
			em.getTransaction().commit();
		}
	}
	public void updateimmagineEroe(String nome, Part immagine) throws IOException {
		if(immagine != null) {
			Eroe eroe = em.find(Eroe.class, nome);
			InputStream f = immagine.getInputStream();
			byte[] imageBytes = new byte[(int) immagine.getSize()];
			f.read(imageBytes, 0, imageBytes.length);
			f.close();
			String imageStr = Base64.getEncoder().encodeToString(imageBytes);
			eroe.setImage(imageStr);
			em.getTransaction().begin();
			em.persist(eroe);
			em.getTransaction().commit();
		}
	}
	public void updateActiveProfile(String username) {
		Utente utente = em.find(Utente.class, username);
		utente.setActive(true);
		em.getTransaction().begin();
		em.merge(utente);
		em.getTransaction().commit();
	}

	public void updateRating(String username, long rating) {
		Utente utente = em.find(Utente.class, username);
		utente.setRating(rating);
		em.getTransaction().begin();
		em.merge(utente);
		em.getTransaction().commit();
	}

/////////////Stampa
	public long stampaNumeroPartiteGiocateComposizione(String username, String eroe, String composizione) {
		TypedQuery<Long> query = em
				.createQuery("SELECT COUNT(p.id) FROM Partita p WHERE p.usernameUtente = ?1 and p.eroe = ?2 and p.composition= ?3", Long.class);
		query.setParameter(1, username);
		query.setParameter(2, eroe);
		query.setParameter(3, composizione);
		return query.getSingleResult();
	}
	
	public List<Partita> stampaListaPartitePerEroe(String username, String eroe) {
		TypedQuery<Partita> query = em.createQuery("select p from Partita p where p.usernameUtente = ?1 and p.eroe = ?2",
				Partita.class);
		query.setParameter(1, username);
		query.setParameter(2, eroe);
		return query.getResultList();
	}
	public long stampaNumeroPartiteGiocateEroe(String username, String eroe) {
		TypedQuery<Long> query = em
				.createQuery("SELECT COUNT(p.id) FROM Partita p WHERE p.usernameUtente = ?1 and p.eroe = ?2", Long.class);
		query.setParameter(1, username);
		query.setParameter(2, eroe);
		return query.getSingleResult();
	}
	public long stampaNumeroTopFourEroe(String username, String eroe) {
		TypedQuery<Long> query = em
				.createQuery("SELECT COUNT(p.id) FROM Partita p WHERE p.usernameUtente = ?1 and p.eroe = ?2 and p.posizione <= 4", Long.class);
		query.setParameter(1, username);
		query.setParameter(2, eroe);
		return query.getSingleResult();
	}
	public long stampaNumeroVincitaEroe(String username, String eroe) {
		TypedQuery<Long> query = em
				.createQuery("SELECT COUNT(p.id) FROM Partita p WHERE p.usernameUtente = ?1 and p.eroe = ?2 and p.posizione = 1", Long.class);
		query.setParameter(1, username);
		query.setParameter(2, eroe);
		return query.getSingleResult();
	}
	public List<Eroe> stampaListaEroi() {
		TypedQuery<Eroe> query = em.createQuery("select e from Eroe e", Eroe.class);
		return query.getResultList();
	}
	public List<Utente> stampaListaUtenti() {
		TypedQuery<Utente> query = em.createQuery("select u from Utente u", Utente.class);
		return query.getResultList();
	}
	public List<Composizione> stampaListaComposizioni() {
		TypedQuery<Composizione> query = em.createQuery("select c from Composizione c", Composizione.class);
		return query.getResultList();
	}

	public List<Partita> stampaListaPartite(String username) {
		TypedQuery<Partita> query = em.createQuery("select p from Partita p where p.usernameUtente = ?1",
				Partita.class);
		query.setParameter(1, username);
		return query.getResultList();
	}

	public long getRating(String username) {
		Utente utente = em.find(Utente.class, username);
		return utente.getRating();
	}

	public long stampaNumeroPartiteGiocate(String username) {
		TypedQuery<Long> query = em
				.createQuery("SELECT COUNT (p.id) FROM Partita p WHERE p.usernameUtente = :usernameUtente", Long.class);
		query.setParameter("usernameUtente", username);
		return query.getSingleResult();
	}

	public long stampaTopFour(String username) {
		long contatore = 0;
		for (Partita p : stampaListaPartite(username)) {
			if (p.getPosizione() <= 4) {
				contatore++;
			}
		}
		return contatore;
	}

	public long stampaVincite(String username) {
		long contatore = 0;
		for (Partita p : stampaListaPartite(username)) {
			if (p.getPosizione() < 2) {
				contatore++;
			}
		}
		return contatore;
	}

	public String stampaEmailUtente(String email) {
		Query query = em.createQuery("select u.username from Utente u where u.email = ?1");
		query.setParameter(1, email);
		return (String) query.getSingleResult();
	}

/////////////Elimina
	public void eliminaComposizione(String nome) {
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Composizione c where c.nome = ?1");
		query.setParameter(1, nome);
		query.executeUpdate();
		em.getTransaction().commit();
	}
	public void eliminaEroe(String nome) {
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Eroe e where e.nome = ?1");
		query.setParameter(1, nome);
		query.executeUpdate();
		em.getTransaction().commit();
	}

	public void eliminaUtente(String username) {
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Utente u where u.username = ?1");
		query.setParameter(1, username);
		  query.executeUpdate();
	      em.getTransaction().commit();
	}

}
