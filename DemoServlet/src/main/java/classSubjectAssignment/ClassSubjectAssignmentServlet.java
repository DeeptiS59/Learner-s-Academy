package classSubjectAssignment;

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
import subject.Subject;

/**
 * Servlet implementation class ClassSubjectAssignmentServlet
 */
@WebServlet("/ClassSubjectAssignment")
public class ClassSubjectAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ClassSubjectAssignmentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 Criteria cr = session.createCriteria(ClassSubjectAssignment.class);
		 List<ClassSubjectAssignment>results = cr.list();
		 String outputHtml= "";
		 for(ClassSubjectAssignment c:results ) {
			 outputHtml+="<option value=\"" +c.getId()+"\">"+c.getClassName()+" - "+c.getSubjectName()+"</option>";
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
	        int classId= Integer.parseInt(request.getParameter("classID"));
	        int subjectId= Integer.parseInt(request.getParameter("subjectID"));
	        Classes c=(Classes) session.get(Classes.class,classId);
	        Subject s=(Subject) session.get(Subject.class,subjectId);
	        ClassSubjectAssignment c1 = new ClassSubjectAssignment(classId,subjectId,c.getName(),s.getName());
	        session.save(c1);
	        tx.commit();
	        session.close();
		doGet(request, response);
	}

}
