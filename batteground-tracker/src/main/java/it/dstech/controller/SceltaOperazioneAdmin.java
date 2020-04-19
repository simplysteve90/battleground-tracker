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
@WebServlet(urlPatterns = ("/scelta-operazione-admin"))
public class SceltaOperazioneAdmin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("homepage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		Service service = new Service(em);
		HttpSession session = req.getSession();
		int scelta = Integer.parseInt(req.getParameter("action"));
		switch (scelta) {
		case 1:{
			req.getRequestDispatcher("aggiungiEroe.jsp").forward(req, resp);
			break;
		}
		case 2:{
			req.setAttribute("listaEroi", service.stampaListaEroi());
			req.getRequestDispatcher("listaEroi.jsp").forward(req, resp);
		}
		default:
			break;
		}
	}
}
