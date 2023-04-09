package teacherAssignment;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import classSubjectAssignment.ClassSubjectAssignment;
import classes.Classes;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import subject.Subject;
import teacher.Teacher;

/**
 * Servlet implementation class TeacherAssignmentServlet
 */
@WebServlet("/TeacherAssignment")
public class TeacherAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TeacherAssignmentServlet() {
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
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		 Session session = sessionFactory.openSession();
	        Transaction tx=session.beginTransaction();
	        int classSubjectId= Integer.parseInt(request.getParameter("classSubjectID"));
	        int teacherId= Integer.parseInt(request.getParameter("teacherID"));
	        Teacher t=(Teacher) session.get(Teacher.class,teacherId);
	        ClassSubjectAssignment cs=(ClassSubjectAssignment) session.get(ClassSubjectAssignment.class,classSubjectId);
	        TeacherAssignment c1 = new TeacherAssignment(classSubjectId,teacherId,cs.getClassId(),t.getName(),cs.getClassName());
	        session.save(c1);
	        tx.commit();
	        session.close();
		doGet(request, response);
	}

}
