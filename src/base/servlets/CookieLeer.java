package base.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieLeer
 */
@WebServlet("/cookie-leer")
public class CookieLeer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// coger una cookie
		// no permite coger solo una, por lo que hay que crear array de cookies y
		// volvarlo.
		Cookie[] cookie = request.getCookies();

		String dato = null;

		// no se puede pedir un nombre en concreto por lo que tengo que recorrerlas
		for (Cookie c : cookie) {

			if ("demo".equals(c.getName())) { // primero la variable de comillas, del literal. Asi nos aseguramos que no
												// va a haber exception
				dato = c.getValue();
				break;
			}
		}

		response.setContentType("text/plain");
		response.getWriter().println(dato);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
