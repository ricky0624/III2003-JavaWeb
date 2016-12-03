package tw.org.iii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileUp
 */
@WebServlet("/FileUp")
public class FileUp extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String type = request.getContentType();
		int len = request.getContentLength();
		out.println(type+":"+len+"<br>");
		
//		BufferedReader reader = request.getReader();
//		String line ; int i=1;
//		while( (line = reader.readLine())!= null)
//		{
//			out.println(i++ +"> "+line+"<br>");
//		}
//		reader.close();
		
		InputStream in = request.getInputStream();
		byte[] buf= new byte[len];
		in.read(buf);
		in.close();
		
		String cont = new String(buf);
		out.println(getFilename(cont));
	}

	private String getFilename(String body)
	{
		int start = body.indexOf("filename=\"");
		String temp = body.substring(start+10);
		String filename = temp.substring(0, temp.indexOf("\""));
		return filename;
	}
}
