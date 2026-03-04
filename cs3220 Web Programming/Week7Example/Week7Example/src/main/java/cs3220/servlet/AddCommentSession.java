package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GuestBookEntry;

/**
 * Servlet implementation class AddCommentSession
 */
@WebServlet("/AddCommentSession")
public class AddCommentSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = (String) request.getSession().getAttribute("name");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<meta name='viewport' content=\"width=device-width, initial-scale==1.0\" />");
		out.println("<title>Add Comment</title>");
		out.println("<style>");
		out.println("td {"
				+ "border: 1px solid black;"
				+ "margin: auto;"
				+ "}");
		out.println("table {"
				+ "margin: auto;"
				+ "}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Add Comment</h2>");
		out.println("<form id='addCommentForm' action='AddCommentSession' method='post'");
		out.println("<label for='name'>Name: </label>");
		
		if (name == null) {
			out.println("<input type=\"text\" id=\"name\" name=\"name\" value=\"\">");
		} else {
			out.println("<input type=\"text\" id=\"name\" name=\"name\" value=\"" + name + "\">");
		}
		
		
		out.println("<br />");
		out.println("<textarea name='message' rows='6' cols='40'></textarea>");
		out.println("<br />");
		out.println("<button>Add Comment</button>");
		out.println("</form>");
		out.println("</body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);		
		String name = (String) request.getParameter("name");
		if (name == null) {
			response.sendRedirect("GuestBook");
			return;
		} else {
			request.getSession().setAttribute("name", name);
		}
		
		String message = request.getParameter("message");
		GuestBookEntry entry = new GuestBookEntry(name, message);
		
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		entries.add(entry);
		
		response.sendRedirect("GuestBook");
	}

}
