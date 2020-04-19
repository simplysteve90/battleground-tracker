package it.dstech.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.service.Service;

@WebServlet(urlPatterns = "/admin/aggiungicomposizione")
public class AggiungiComposizione extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("homepage.jsp").forward(req, resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
	EntityManager em = emf.createEntityManager();
	Service service = new Service(em);
	String nome= req.getParameter("nome");
	if (!service.checkEsistenzaComposizione(nome)) {
		service.aggiungiComposizione(nome);
		req.setAttribute("messaggio", "Composizione aggiunta");
		req.getRequestDispatcher("/aggiungiComposizione.jsp").forward(req, resp);
	} else {
		req.setAttribute("messaggio", "Composizione gia esistente");
		req.getRequestDispatcher("/aggiungiComposizione.jsp").forward(req, resp);
	}
}
}
