package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GuestBookEntry;

/**
 * Servlet implementation class GuestBook
 */
@WebServlet("/GuestBook")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestBook() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry("John", "Hello!"));
		entries.add(new GuestBookEntry("Jane", "Hello Again!"));
		
		getServletContext().setAttribute("entries", entries);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<meta name='viewport' content=\"width=device-width, initial-scale==1.0\" />");
		out.println("<title>Guest Book</title>");
		out.println("<style>");
		out.println("td {"
				+ "border: 1px solid black;"
				+ "margin: auto;"
				+ "}");
		out.println("table {"
				+ "margin: auto;"
				+ "border-collapse: collapse;"
				+ "}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Guest Book</h2>");
		out.println("<table>");
		out.println("<tr><th>Name</th><th>Message</th></tr>");
		for (GuestBookEntry entry : entries) {
			out.println("<tr>");
			out.println("<td>" + entry.getName() + "</td>");
			out.println("<td>" + entry.getMessage() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<p><a href='AddCommentSession'>Add Comment</a></p>");
		// out.println("<p><a href='AddComment'>Add Comment</a></p>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
