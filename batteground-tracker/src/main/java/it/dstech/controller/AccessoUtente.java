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

import it.dstech.cryptography.Utility;
import it.dstech.service.Service;

@WebServlet(urlPatterns = { "/accesso"})
public class AccessoUtente extends HttpServlet {
	private static final String CHIAVE = "Mary has one cat";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("/homepage").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		Service service = new Service(em);
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = Utility.encrypt(req.getParameter("password") ,CHIAVE );
		String action = req.getParameter("action");
		if(action.equals("1")) {
			if(service.checkEsistenzaUtente(username, password)) {
				if(service.checkRuolo(username)) {
					session.setAttribute("username", username);
					req.getRequestDispatcher("/WEB-INF/admin/profiloAdmin.jsp").forward(req, resp);
				}else if(service.checkActiveMail(username)) {
					session.setAttribute("username", username);
					session.setAttribute("password", password);
				
					req.getRequestDispatcher("/profiloUtente.jsp").forward(req, resp);
				}else {
					
					req.getRequestDispatcher("homepage.jsp").forward(req, resp);
				}
			}else {
			
				req.setAttribute("messaggio", "Utente inesistente");
				req.getRequestDispatcher("homepage.jsp").forward(req, resp);
			}
		}else {

			req.getRequestDispatcher("registrazione.jsp").forward(req, resp);
		}
	}
}
