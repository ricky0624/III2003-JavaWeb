package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad03")
public class Brad03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// process request
		int x, y, op, result;
		try{
			x = Integer.parseInt(request.getParameter("x"));
			op = Integer.parseInt(request.getParameter("op"));
			y = Integer.parseInt(request.getParameter("y"));
		}catch (Exception ne){
			x = 0; y = 0; op = 1; 
		}
		switch(op){
			default:
			case 1: result = x + y; break;
			case 2: result = x - y; break;
			case 3: result = x * y; break;
			case 4: result = x / y; break;
		}
		
		// Output
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<form>");
		out.println("<input type='text' name='x' />");
		out.println("<select name='op'>");
		out.println("<option value='1' " + (op==1?"selected":"") + ">+</option>");
		out.println("<option value='2' " + (op==2?"selected":"") + ">-</option>");
		out.println("<option value='3' " + (op==3?"selected":"") + ">x</option>");
		out.println("<option value='4' " + (op==4?"selected":"") + ">/</option>");
		out.println("</select>");
		out.println("<input type='text' name='y' />");
		out.println("<input type='submit' value='=' />");
		out.println("<span>" + result + "<span>");
		out.println("</form>");
		out.flush();
		out.close();
		
	}
}
