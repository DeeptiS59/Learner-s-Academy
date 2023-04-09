package student;

public class Student {
	private int id,classId;  
	private String name,className;  
	public Student(){}
	public Student(String name, int classId,String className) {
		this.name = name;
		this.classId=classId;
		this.className = className;
		
	}
	
	 
	public int getId() {  
	    return id;  
	}  
	public void setId(int id) {  
	    this.id = id;  
	}  
	public String getName() {  
	    return name;  
	}  
	public void setName(String name) {  
	    this.name = name;  
	}  
	public String getclassName() {  
	    return className;  
	}  
	public void setClassName(String className) {  
	    this.className = className;  
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}  
}  