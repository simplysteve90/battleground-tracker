package it.dstech.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.model.Partita;
import it.dstech.service.Service;

public class ListaPartiteUtente extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		HttpSession session = req.getSession();
		Service service = new Service(em);
		String username = (String) session.getAttribute("username");
		List<Partita> stampaListaPartite = service.stampaListaPartite(username);
		req.setAttribute("listaPartiteUtente", stampaListaPartite);
		req.getRequestDispatcher("partiteUtente.jsp").forward(req, resp);
	}
	
}
