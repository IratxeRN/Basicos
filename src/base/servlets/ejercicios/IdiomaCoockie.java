package base.servlets.ejercicios;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IdiomaCoockie
 */
@WebServlet("/idioma")
public class IdiomaCoockie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idioma = request.getParameter("idioma");
		Cookie leng_cookie = new Cookie("leng", idioma);
		leng_cookie.setMaxAge(60 * 60); // tiempo una hora.
		response.addCookie(leng_cookie);

//		response.setContentType("text/plain");
//		response.getWriter().print("Has elegido en el desplegable: " + idioma + "\n");
//		response.getWriter().print("Se ha creado la cookie: " + leng_cookie.getName() + " - " + leng_cookie.getValue());

		// guarda el dato y manda al get para q se vuelva a cargar el jsp
		response.sendRedirect("formCookie.jsp");

	}

}
