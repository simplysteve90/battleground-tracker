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
@WebServlet(urlPatterns = ("/admin/scelta-operazione-admin"))
public class SceltaOperazioneAdmin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/homepage").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		Service service = new Service(em);
		int scelta = Integer.parseInt(req.getParameter("action"));
		switch (scelta) {
		case 1:{
			service.close();
			req.getRequestDispatcher("/aggiungiEroe.jsp").forward(req, resp);
			break;
		}
		case 2:{
			req.setAttribute("listaEroi", service.stampaListaEroi());
			service.close();
			req.getRequestDispatcher("/listaEroi.jsp").forward(req, resp);
			break;
		}
		case 3:{
			req.setAttribute("listaComposizioni", service.stampaListaComposizioni());
			service.close();
			req.getRequestDispatcher("/aggiungiComposizione.jsp").forward(req, resp);
			break;
		}
		case 4:{
			req.setAttribute("listaComposizioni", service.stampaListaComposizioni());
			service.close();
			req.getRequestDispatcher("/listaComposizioni.jsp").forward(req, resp);
			break;
		}
		case 5:{
			req.setAttribute("listaUtenti", service.stampaListaUtenti());
			service.close();
			req.getRequestDispatcher("/listaUtenti.jsp").forward(req, resp);
			break;
		}
		case 6:{
			service.close();
			resp.sendRedirect("/battleground-tracker/logout");
			break;
		}
		}
	}
	
}
