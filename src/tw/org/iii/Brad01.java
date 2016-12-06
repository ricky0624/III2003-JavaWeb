package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/III01.php")
public class Brad01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	@Override
//	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//		super.service(request, response);
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		doTask(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("doPost");
		doTask(request,response);
	}
	
	private void doTask(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> headers =  request.getHeaderNames();
		while ( headers.hasMoreElements()){
			String header = headers.nextElement();
			System.out.println(header + " : " + request.getHeader(header));
		}
		try{
			PrintWriter out = response.getWriter();
			out.write("Hello, Brad01");
			out.flush();
			out.close();
		}catch(Exception ee){
			
		}
		
		
	}

}

