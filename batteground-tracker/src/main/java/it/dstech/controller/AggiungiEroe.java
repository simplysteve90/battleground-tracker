package it.dstech.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import it.dstech.service.Service;

@WebServlet(urlPatterns = ("/aggiungi-eroe"))
@MultipartConfig
public class AggiungiEroe extends HttpServlet {
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
		String nome = req.getParameter("nome");
		Part immagine = req.getPart("immagine");
		String heroPower = req.getParameter("power");
		if (!service.checkEsistenzaEroe(nome)) {
			service.aggiungiEroe(nome, immagine, heroPower);
			req.setAttribute("messaggio", "Eroe aggiunto");
			req.getRequestDispatcher("aggiungiEroe.jsp").forward(req, resp);
		} else {
			req.setAttribute("messaggio", "Eroe gia esistente");
			req.getRequestDispatcher("aggiungiEroe.jsp").forward(req, resp);
		}
	}
}
