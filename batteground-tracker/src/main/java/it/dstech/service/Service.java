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
		Query createQuery = em.createQuery("select u from Utente u where u.username = :x and u.password= :y");
		createQuery.setParameter("x", username);
		createQuery.setParameter("y", password);
		 Utente u= (Utente) createQuery.getSingleResult();
		if (u != null) {
			return true;
		}return false;
	}

}
