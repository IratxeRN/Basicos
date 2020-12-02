package base.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionExamples
 */
@WebServlet("/SessionExamples")
public class SessionExamples extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(true);

		// print session info

		Date created = new Date(session.getCreationTime());
		Date accessed = new Date(session.getLastAccessedTime());
		out.println("ID " + session.getId());
		out.println("Created: " + created);
		out.println("Last Accessed: " + accessed);

		// set session info if needed

		String dataName = request.getParameter("dataName");
		if (dataName != null && dataName.length() > 0) {
			String dataValue = request.getParameter("dataValue");
			session.setAttribute(dataName, dataValue);
		}

		// print session contents

		Enumeration e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = session.getAttribute(name).toString();
			out.println(name + " = " + value);
		}
	}
}