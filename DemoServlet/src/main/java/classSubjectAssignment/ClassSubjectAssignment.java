package classSubjectAssignment;

public class ClassSubjectAssignment {
	private int id,classId,subjectId;  
	private String className,subjectName;
	public ClassSubjectAssignment(){
		
	}
	
	public ClassSubjectAssignment(int classId,int subjectId, String className, String subjectName) {
		this.classId = classId;	
		this.subjectId = subjectId;
		this.subjectName= subjectName;
		this.className= className;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
}
