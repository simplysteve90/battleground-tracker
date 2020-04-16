package it.dstech.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import it.dstech.model.Utente;

public class Service {
	private EntityManager em;

	public Service(EntityManager em) {
		this.em = em;
	}

	public boolean checkEsistenzaUtente(String username, String password) {
		Query createQuery = em.createQuery("select (u.username, u.password) from Utente u where u.username = :x");
		createQuery.setParameter(1, username);
		String usernameUtente = (String) createQuery.setParameter("username", username).getSingleResult();
		String passwordUtente = (String) createQuery.setParameter("password", password).getSingleResult();
		if (username.equals(usernameUtente) && password.equals(passwordUtente)) {
			return true;
		}return false;
	}

}
