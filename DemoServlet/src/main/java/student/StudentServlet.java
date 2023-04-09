package student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import classes.Classes;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // loads configuration and creates a session factory
        Configuration configuration = new Configuration().configure();
        //StandardServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        //registry.applySettings(configuration.getProperties());
        //ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
         
        // opens a new session from the session factory
        Session session = sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        // persists two new Contact object
        String sname=request.getParameter("name");
        int classId= Integer.parseInt(request.getParameter("classID"));
        Classes c=(Classes) session.get(Classes.class,classId);
        Student s1 = new Student(sname,classId,c.getName());
        session.save(s1);
        tx.commit();
        session.close();
		doGet(request, response);
	}

}
