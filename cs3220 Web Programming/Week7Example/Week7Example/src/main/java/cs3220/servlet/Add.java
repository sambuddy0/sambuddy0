package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

    private boolean isNumeric(String inputString) {
    	Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    	if (inputString == null) {
    		return false;
    	}
    	return pattern.matcher(inputString).matches();
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
		
		if (!this.isNumeric(request.getParameter("a")) || !this.isNumeric(request.getParameter("b"))) {
			response.sendRedirect("AddForm.html");
			return;
		}
		
		int a = (this.isNumeric(request.getParameter("a"))) ? Integer.parseInt(request.getParameter("a")) : 0;
		int b = (this.isNumeric(request.getParameter("b"))) ? Integer.parseInt(request.getParameter("b")) : 0;
		
		int sum = a + b;
		out.println("<h2>The sum of "+ a + " and " + b + " is: " + sum + "</h2>");
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
