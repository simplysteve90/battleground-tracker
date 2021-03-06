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
import javax.servlet.http.Part;

import it.dstech.service.Service;

@WebServlet(urlPatterns = ("/admin/aggiungi-eroe"))
@MultipartConfig
public class AggiungiEroe extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/homepage").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		Service service = new Service(em);
		String nome = req.getParameter("nome");
		Part immagine = req.getPart("immagine");
		String heroPower = req.getParameter("power");
		String costo= req.getParameter("costo");
		String descrizione= req.getParameter("descrizione");
		if (!service.checkEsistenzaEroe(nome)) {
			service.aggiungiEroe(nome, immagine, heroPower, costo, descrizione);
			req.setAttribute("listaEroi", service.stampaListaEroi());
			req.setAttribute("messaggio", "Eroe aggiunto");
			req.getRequestDispatcher("/WEB-INF/admin/aggiungiEroe.jsp").forward(req, resp);
		} else {
			req.setAttribute("messaggio", "Eroe gia esistente");
			req.getRequestDispatcher("/WEB-INF/admin/aggiungiEroe.jsp").forward(req, resp);
		}
	}
}
