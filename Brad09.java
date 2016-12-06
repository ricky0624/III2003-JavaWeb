package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(location="C:/javaee/git/JavaWeb/WebContent/upload3")
@WebServlet("/Brad09")
public class Brad09 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// ���葉�������, 敹�隞颱��  request銋���身摰�
		request.setCharacterEncoding("UTF-8");
		
		Collection<Part> parts= request.getParts();
		for (Part part : parts){
			String header = part.getHeader("Content-Disposition"); //Content-Disposition
			
			String myfilename = getFilename(header);
			long size = part.getSize();
			
			out.print(myfilename + ":" + size + "<br>");
			if (size>0){
				part.write(myfilename);
			}
		}
		
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
