package teacherAssignment;

public class TeacherAssignment {
	private int id,teacherId,classSubjectId,classId;  
	private String teacherName,className;
	public TeacherAssignment(){
		
	}
	
	public TeacherAssignment(int teacherId,int classSubjectId, int classId, String teacherName, String className) {
		this.teacherId = teacherId;	
		this.classSubjectId = classSubjectId;
		this.classId = classId;
		this.className = className;
		this.teacherName = teacherName;	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getClassSubjectId() {
		return classSubjectId;
	}

	public void setClassSubjectId(int classSubjectId) {
		this.classSubjectId = classSubjectId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	
}
