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

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
       System.out.println("Hello()");
    }

	@Override
	public void init() throws ServletException {
		System.out.println("init()");
		//super.init();
	}

	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//System.out.println("service()");
		//super.service(arg0, arg1);
//		String key1 = request.getParameter("key1");
//		System.out.println("key1=" + key1);
//		String key2 = request.getParameter("key2");
//		System.out.println("key2=" + key2);
		

	
	try
	{
		HttpServletRequest rq = (HttpServletRequest)request;
		String method = rq.getMethod();
		System.out.println(method);
		Enumeration<String> ps = request.getParameterNames();
		while(ps.hasMoreElements())
		{
			String item = ps.nextElement();
			String value = request.getParameter(item);
			System.out.println(item + " => " + value);
		}
	}
	
	catch(ClassCastException ce)
	{
		System.out.println(ce.toString());
	}
	
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
		System.out.println("doPost()");
	}

	
}
