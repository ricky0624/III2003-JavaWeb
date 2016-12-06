package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad02")
public class Brad02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// process request
		int x, y, result;
		try{
			x = Integer.parseInt(request.getParameter("x"));
			y = Integer.parseInt(request.getParameter("y"));
		}catch (Exception ne){
			x = 0; y = 0;
		}
		result = x + y;
		
		// Output
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<form>");
		out.println("<input type='text' name='x' value='" + x + "' /> + ");
		out.println("<input type='text' name='y' value='" + y + "' />");
		out.println("<input type='submit' value='=' />");
		out.println("<span>" + result + "<span>");
		out.println("</form>");
		out.flush();
		out.close();
		
	}
}
