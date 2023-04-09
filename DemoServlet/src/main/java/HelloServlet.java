

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter p=response.getWriter();
		String s1=request.getParameter("t1");
		String s2=request.getParameter("password");
		if(s1.equals("Admin") && s2.equals("123"))
		  {
		    p.println("Welcome  "+s1  + " and your password is "+ s2);
		  }
		  else
		  {
		    p.println("Invalid login credentials");
		  }		
		
	
		p.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter p=response.getWriter();
		String s1=request.getParameter("t1");
		String s2=request.getParameter("password");
		if(s1.equals("Admin") && s2.equals("123"))
		  {
			RequestDispatcher rd=request.getRequestDispatcher("/homePage.html"); 
			rd.include(request, response);
		  }
		  else
		  {
			//p.print("Invalid Login Credentials");
			RequestDispatcher rd=request.getRequestDispatcher("/input.html"); 
			rd.include(request, response);
		  }		
		
		
		p.close();
		
	}

}
