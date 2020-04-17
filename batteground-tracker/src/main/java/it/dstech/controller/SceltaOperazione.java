package it.dstech.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.model.Partita;
import it.dstech.service.Service;
@WebServlet(urlPatterns = ("/utente/scelta"))
public class SceltaOperazione extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int action= Integer.parseInt(req.getParameter("action"));
	EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
	EntityManager em = emf.createEntityManager();
	HttpSession session = req.getSession();
	String username = (String) session.getAttribute("username");
	Service service= new Service(em);
	switch (action) {
	
	case 1:
		req.setAttribute("listaComposizioni", service.stampaListaComposizioni());
		req.setAttribute("listaEroi", service.stampaListaEroi());
		req.getRequestDispatcher("/aggiungiPartita.jsp").forward(req, resp);
		
		break;
	case 2:{
		List<Partita> stampaListaPartite = service.stampaListaPartite(username);
		req.setAttribute("listaPartiteUtente", stampaListaPartite);
		req.getRequestDispatcher("/partiteUtente.jsp").forward(req, resp);
	}
	default:
		break;
	}
	}
}
