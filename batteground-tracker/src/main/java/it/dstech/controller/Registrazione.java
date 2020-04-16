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

@WebServlet(urlPatterns = "/registrazione")
public class Registrazione extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		Service service= new Service(em);
		if(!service.checkRegistrazione(username)) {
			service.creazioneUtente(username,password);
			session.setAttribute("username", username);
			req.getRequestDispatcher("profiloUtente.jsp").forward(req, resp);
			
			
		}else {
			req.setAttribute("messaggio", "Username gia' in uno");
			req.getRequestDispatcher("registrazione.jsp").forward(req, resp);
	}

	
		
	}

}
