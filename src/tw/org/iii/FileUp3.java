package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUp3
 */
@MultipartConfig(location="C:/javaee/workspace/JavaWeb/WebContent/upload2")
@WebServlet("/FileUp3")
public class FileUp3 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Part part = request.getPart("upload");
		
		String header = part.getHeader("Content-Disposition"); //Content-Disposition
		String myfilename = getFilename(header);
		
		part.write(myfilename);
	}
	
	private String getFilename(String body){
		int start = body.indexOf("filename=\"");
		String temp = body.substring(start+10);
		String filename = temp.substring(0, temp.indexOf("\""));
		int s = filename.lastIndexOf("\\");
		filename = filename.substring(s+1);
		
		return filename;
	}
}
