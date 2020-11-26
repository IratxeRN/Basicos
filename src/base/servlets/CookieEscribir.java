package base.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieEscribir
 */
@WebServlet("/cookie-escribir")
public class CookieEscribir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// crear una cookies.
		Cookie cookie = new Cookie("demo", "decookieXXX");

		// maximo tiempo que dure la cookie
		cookie.setMaxAge(60 * 60 * 24 * 7);// en segundos. Una semana
		/// cookie.setMaxAge(Integer.MAX_VALUE); // El maximo de dias que se pueda
		response.addCookie(cookie);

		response.setContentType("text/plain");
		response.getWriter().println("Cookie escrita");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
