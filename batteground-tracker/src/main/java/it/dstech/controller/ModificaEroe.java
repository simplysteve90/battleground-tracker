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

@WebServlet(urlPatterns = "/admin/modifica-eroe")
@MultipartConfig
public class ModificaEroe extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("homepage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		Service service = new Service(em);
		String nome = req.getParameter("nome");
		String power = req.getParameter("power");
		Part immagine = req.getPart("immagine");
		service.updatePowerEroe(nome, power);
		service.updateimmagineEroe(nome, immagine);
		req.setAttribute("listaEroi", service.stampaListaEroi());
		service.close();
		req.getRequestDispatcher("/listaEroi.jsp").forward(req, resp);
	}
}
