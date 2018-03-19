package br.com.voffice.cinema.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unused")
@WebServlet("/session")
public class SessionController extends HttpServlet  {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String learner = req.getParameter("learner");
		req.getServletContext().setAttribute("algo", "xxx");
		String savedLearner = (String) req.getSession().getAttribute("learner");
		String message = "";
		if (savedLearner == null) {
			req.getSession().setAttribute("learner", learner);
			message = learner+" salvo com sucesso";
		} else {
			 message = "Learner "+savedLearner+" obtido da sessao";
		}
		resp.getWriter().write(message);
	}
}
