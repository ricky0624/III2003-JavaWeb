package tw.org.iii;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/FileUp2")
public class FileUp2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Part part = request.getPart("upload");
		
		String header = part.getHeader("Content-Disposition");
		out.println(header + "<br>");
		
		String filename = part.getSubmittedFileName();
		String name = part.getName();
		String type = part.getContentType();
		long len = part.getSize();
		out.println(type + ":" + name + ":" + filename + ":" + len);
		
		byte[] buf = new byte[(int)len];
		BufferedInputStream bin = new BufferedInputStream(part.getInputStream());
		bin.read(buf);
		bin.close();
		
		ServletContext context = getServletContext();
		String uploadPath = context.getInitParameter("upload-path");
		out.println(uploadPath);
		
		FileOutputStream fout = new FileOutputStream(new File(uploadPath, "test.jpg"));
		fout.write(buf);
		fout.flush();
		fout.close();
	}

}
