package cs3220.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = "images";
		String imagePath = "/Users/robertlai/CS3220/workspace/Week7Example/src/main/webapp/assets/images/images.jpeg";
		
		File file = new File(imagePath);
		FileInputStream in = new FileInputStream(file);
		ServletOutputStream out = response.getOutputStream();
		
		response.setContentType("image/jpg");
		// response.setHeader("Content-Disposition", "inline; filename=MyApple.jpg");
		response.setHeader("Content-Disposition", "attachment; filename=MyApple.jpg");
		
		byte[] buffer = new byte[2048];
		int bytesRead;
		while ((bytesRead = in.read(buffer)) > 0) {
			out.write(buffer, 0, bytesRead);
		}
		in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
