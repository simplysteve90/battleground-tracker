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
@WebServlet(urlPatterns = "/admin/elimina-utente")
public class ModificaUtente extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("/homepage").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		Service service = new Service(em);
		String username = req.getParameter("username");
		service.eliminaUtente(username);
		req.setAttribute("listaUtenti", service.stampaListaUtenti());
		req.getRequestDispatcher("/WEB-INF/admin/listaUtenti.jsp").forward(req, resp);
	}
}
