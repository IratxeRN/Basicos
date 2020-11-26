package base.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundo
 */
@WebServlet("/hola/*")
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String respuesta = "Hola ";
		String nombre = request.getParameter("nombre");

		if (nombre == null) {
			respuesta += "a todos";
		} else {
			respuesta += nombre;
		}

		response.setContentType("text/plain");
		response.getWriter().print(respuesta);

		response.getWriter().println(request.getHeader("referer"));

		PrintWriter out = response.getWriter();

		out.println(request.getMethod());
		out.println(request.getPathInfo());
		out.println(request.getMethod());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
