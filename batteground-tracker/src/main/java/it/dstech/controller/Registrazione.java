package it.dstech.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.dstech.validation.EmailUtility;
import it.dstech.cryptography.Utility;
import it.dstech.service.Service;

@WebServlet(urlPatterns = "/registrazione")
public class Registrazione extends HttpServlet {
	private static final String CHIAVE = "Mary has one cat";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/homepage").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = Utility.encrypt(req.getParameter("password") ,CHIAVE );
		String email = req.getParameter("email");
		long rating = Long.parseLong(req.getParameter("rating"));
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		Service service = new Service(em);
		if (!service.checkRegistrazione(username) && !service.checkEstistenzaEmail(email, username)) {
			service.creazioneUtente(username, email, password, rating);
			try {
				EmailUtility.sendEmail(email, "Conferma Mail", generaLinkValidazioneUtente(email));
			} catch (MessagingException | IOException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("homepage.jsp").forward(req, resp);
		} else {
			req.setAttribute("messaggio", "Username gia' in uso");
			req.getRequestDispatcher("registrazione.jsp").forward(req, resp);
		}
	}
	private String generaLinkValidazioneUtente(String email) {
		String validationPath = "http://localhost:8080/battleground-tracker/validazione?email=";
		return "Per attivare la mail clicca su questo link: " + validationPath + email;
	}
}
