package base.servlets.ejercicios;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginSesion
 */
@WebServlet("/login")
public class loginSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession();

		String correo = (String) sesion.getAttribute("correo");
		String clave = (String) sesion.getAttribute("clave");

		response.setContentType("text/plain");
		response.getWriter().printf("La sesion tiene correo:%s y clave:%s", correo, clave);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String mail2 = "kk@kk.com";
		final String pass2 = "cocoLOCO";

		String mail = request.getParameter("correo");
		String pass = request.getParameter("clave");

		if (mail2.equalsIgnoreCase(mail) && pass.equals(pass2)) {

			HttpSession sesion = request.getSession();

			sesion.setAttribute("correo", mail);
			sesion.setAttribute("clave", pass);

			response.sendRedirect("login");

		} else {

			response.getWriter().println("Clave o pass erroneos");
		}

	}

}
