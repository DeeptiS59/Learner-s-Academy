package teacher;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import classes.Classes;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import student.Student;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/Teacher")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TeacherServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 Criteria cr = session.createCriteria(Teacher.class);
		 List<Teacher>results = cr.list();
		 String outputHtml= "";
		 for(Teacher c:results ) {
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
	        String tname=request.getParameter("name");
	        Teacher t1 = new Teacher(tname);
	        session.save(t1);
	        tx.commit();
	        session.close();
		doGet(request, response);
	}

}
