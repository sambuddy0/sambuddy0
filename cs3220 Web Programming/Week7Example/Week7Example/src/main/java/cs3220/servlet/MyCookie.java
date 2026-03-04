package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyCookie
 */
@WebServlet("/MyCookie")
public class MyCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCookie() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String getNameFromCookie(HttpServletRequest request) {
    	Cookie[] cookies =request.getCookies();
    	if (cookies != null) {
    		for (Cookie cookie : cookies) {
    			if (cookie.getName().equals("name")) {
    				return cookie.getValue();
    			} else {
    				continue;
    			}
    		}
    	}
    	return null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name = this.getNameFromCookie(request);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>My Cookie</title></head><body>");
		
		if (name != null) {
			out.println("<h2>Hello " + name + "</h2>");
		} else {
			out.println("<form id='myCookieForm' action='MyCookie' method='POST'>");
			out.println("<label for='name'>Name: </label>");
			out.println("<input type='text' id='name' name='name'>");
			out.println("<br />");
			out.println("<button>Submit</button>");
			out.println("</form>");
		}
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String name = request.getParameter("name");
		Cookie cookie = new Cookie("name", name);
		response.addCookie(cookie);
		response.sendRedirect("MyCookie");
	}

}
