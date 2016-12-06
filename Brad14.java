package tw.org.iii;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad14")
public class Brad14 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String x = (String)request.getAttribute("x");
		String y = (String)request.getAttribute("y");
		String res = (String)request.getAttribute("res");
		
		// Load view1.html
		String htmlString = loadView("view1.html");
		htmlString = String.format(htmlString, x,y,res);
		out.println(htmlString);
	}
	
	private String loadView(String file){
		String templatePath = 
				getServletContext().getInitParameter("template-path");
		File tempFile = new File(templatePath, file);
		long len = tempFile.length();
		byte[] buf = new byte[(int)len];
		try{
			BufferedInputStream bin =
					new BufferedInputStream(
							new FileInputStream(tempFile));
			bin.read(buf);
			bin.close();
		}catch(Exception ee){
			
		}
		
		return new String(buf);
	}
	

}