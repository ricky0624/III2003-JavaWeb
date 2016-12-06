package tw.org.iii;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad12")
public class Brad12 extends HttpServlet {
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html; charset=utf-8");
		
		// 0. prepare
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		if (x == null) x = "0";
		if (y == null) y = "0";
		
		// 1. Model
		Brad13 brad = new Brad13();
		String res = brad.cal(x, y);
		
		// 2. forward => View
		request.setAttribute("x", x);
		request.setAttribute("y", y);
		request.setAttribute("res", res);
		request.getRequestDispatcher("Brad14")
		.forward(request, response);
		
	}
}
