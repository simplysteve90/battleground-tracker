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
@WebServlet(urlPatterns = "/utente/statistiche-eroe")
public class StatistichePerEroe extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/homepage").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		Service service = new Service(em);
		String nomeEroe = req.getParameter("eroe");
		req.setAttribute("nome", nomeEroe);
		long stampaNumeroTopFourEroe = service.stampaNumeroTopFourEroe(username, nomeEroe);
		long stampaNumeroPartiteGiocateEroe = service.stampaNumeroPartiteGiocateEroe(username, nomeEroe);
		req.setAttribute("numeroTopFourEroePercentuale", percentualeTopFour(stampaNumeroPartiteGiocateEroe, stampaNumeroTopFourEroe));
		req.setAttribute("numeroVinciteEroe", service.stampaNumeroVincitaEroe(username, nomeEroe));
		req.setAttribute("numeroPartiteEroe", stampaNumeroPartiteGiocateEroe);
		req.setAttribute("numeroTopFourEroe", stampaNumeroTopFourEroe);
		req.setAttribute("listaEroi", service.stampaListaEroi());
		req.setAttribute("listaPartite", service.stampaListaPartitePerEroe(username, nomeEroe));
		req.getRequestDispatcher("/statistichePartite.jsp").forward(req, resp);
	}
	public static double percentualeTopFour(long totale, long topFour) {
		if(totale != 0) {
			return (topFour * 100) / totale;
		}return 0.0;
	}
	public static List<Partita> listaPartitePerComp(long numeroPartite, List<Partita> x){
		int contatore=0;
				for (Partita partita : x) {
			
			if(numeroPartite<=4) {
				contatore++;
			}
			
		}
		return null ;
	}
}
