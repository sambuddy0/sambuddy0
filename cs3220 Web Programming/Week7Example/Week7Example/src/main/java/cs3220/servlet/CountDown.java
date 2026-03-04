package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountDown
 */
@WebServlet("/CountDown")
public class CountDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int count=10;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountDown() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Add</title></head><body>");
		if (this.count == 0) {
			out.println("<h2>Your count is " + this.count + "</h2>");
		} else {
			response.setHeader("refresh", "1");
			out.println("<h2>Current count is " + this.count + "</h2>");
			--this.count;
		}
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
