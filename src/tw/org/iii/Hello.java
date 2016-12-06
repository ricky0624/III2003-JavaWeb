package tw.org.iii;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Hello() {
    	System.out.println("Hello()");
    }
    
    

//	@Override
//	public void init() throws ServletException {
//		super.init();
//		//����惇��
//	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service()");
		//super.service(request, response);
		
		try{
			HttpServletRequest req = (HttpServletRequest)request;
			String method = req.getMethod();
			System.out.println(method);
			
//			String key1 = request.getParameter("key1");
//			System.out.println("key1 = " + key1);
//			String key2 = request.getParameter("key2");
//			System.out.println("key2 = " + key2);

			Enumeration<String> ps = req.getParameterNames();
			while (ps.hasMoreElements()){
				String item = ps.nextElement();
				String value = req.getParameter(item);
				System.out.println(item + " => " + value);
			}
			
		}catch(ClassCastException ce){
			System.out.println(ce.toString());
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		//response.getWriter().append("Served @: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		//doGet(request, response);
	}

}
