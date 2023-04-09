package classes;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import teacher.Teacher;

/**
 * Servlet implementation class ClassServlet
 */
@WebServlet("/Class")
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ClassServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 Criteria cr = session.createCriteria(Classes.class);
		 List<Classes>results = cr.list();
		 String outputHtml= "";
		 for(Classes c:results ) {
			 outputHtml+="<option value=\"" +c.getId()+"\">"+c.getName()+"</option>";
		 }
		 response.getWriter().append(outputHtml);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		 Session session = sessionFactory.openSession();
	        Transaction tx=session.beginTransaction();
	        String cname=request.getParameter("name");
	        Classes c1 = new Classes(cname);
	        session.save(c1);
	        tx.commit();
	        session.close();
		doGet(request, response);
		
	}

}
