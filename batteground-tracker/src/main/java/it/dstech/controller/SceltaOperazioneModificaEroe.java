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

import it.dstech.service.Service;

@WebServlet(urlPatterns = "/admin/scelta-modifica")
@MultipartConfig
public class SceltaOperazioneModificaEroe extends HttpServlet {
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
		int action = Integer.parseInt(req.getParameter("action"));
		switch (action) {
		case 1: {
			req.setAttribute("nome", nome);
			req.setAttribute("immagine", req.getParameter("immagine"));
			req.setAttribute("costo", req.getParameter("costo"));
			req.setAttribute("power", req.getParameter("power"));
			req.setAttribute("descrizione", req.getParameter("descrizione"));
			req.getRequestDispatcher("/WEB-INF/admin/modificaEroe.jsp").forward(req, resp);
			break;
		}
		case 2:{
			service.eliminaEroe(nome);
			req.setAttribute("listaEroi", service.stampaListaEroi());
			req.getRequestDispatcher("/WEB-INF/admin/listaEroi.jsp").forward(req, resp);
			break;
		}
		} 
	}
}
