

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import classSubjectAssignment.ClassSubjectAssignment;
import classes.Classes;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import student.Student;
import teacherAssignment.TeacherAssignment;

/**
 * Servlet implementation class ClassReportServlet
 */
@WebServlet("/ClassReport")
public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ClassReportServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classId= Integer.parseInt(request.getParameter("classID"));
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 String outputHtml= "<html><head><title>Class Report</title></head><body>";
		 Criteria cr = session.createCriteria(Student.class);
		 cr.add(Restrictions.eq("classId",classId));
		 outputHtml+="<b>Students in this Class</b><br>";
		 List<Student>results = cr.list();
		 for(Student s:results) {
			 outputHtml+=s.getName()+"<br>";
		 }
		 outputHtml+="<br><b>Subjects in this class</b><br>";
		 Criteria cr2 = session.createCriteria(ClassSubjectAssignment.class);
		 cr2.add(Restrictions.eq("classId",classId));
		 List<ClassSubjectAssignment>results2 = cr2.list();
		 for(ClassSubjectAssignment cs:results2) {
			 outputHtml+=cs.getSubjectName()+"<br>";
		 }
		 outputHtml+="<br><b>Teachers teaching to the students of this Class</b><br>";
		 Criteria cr3 = session.createCriteria(TeacherAssignment.class);
		 cr3.add(Restrictions.eq("classId",classId));
		 List<TeacherAssignment>results3 = cr3.list();
		 for(TeacherAssignment t:results3) {
			 outputHtml+=t.getTeacherName()+"<br>";
		 }
		 outputHtml+="<br></body></html>";
		 response.getWriter().append(outputHtml);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
