package it.dstech.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.service.Service;

@WebServlet(urlPatterns = ("/utente/partita"))
public class NuovaPartita extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/homepage").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		HttpSession session = req.getSession();
		Service service= new Service(em);
		String username = (String) session.getAttribute("username");
		String eroe = req.getParameter("eroe");
		String composizione = req.getParameter("composizione");
		String note = req.getParameter("note");
		int punteggio = Integer.parseInt(req.getParameter("punteggio"));
		int posizione = Integer.parseInt(req.getParameter("posizione"));
		long calcolaRating = service.getRating(username) + (punteggio);
		service.aggiungiPartita(username, composizione, eroe, note, punteggio, posizione);
		service.updateRating(username, calcolaRating);
		req.getRequestDispatcher("/profiloUtente.jsp").forward(req, resp);
	}
}
