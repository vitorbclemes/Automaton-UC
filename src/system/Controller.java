package system;
import java.util.ArrayList;
import data.Nodo;
import data.Student;


public class Controller {
	public ArrayList<Nodo> nodes;
	public ArrayList<Student> students;

	public void setNodes(ArrayList<Nodo> nodes) {
		this.nodes = nodes;
	}
	
	public ArrayList<Nodo> getAllNodes(){
		return nodes;
	}
	
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	public ArrayList<Student> getAllStudents(){
		return students;
	}
	
	
	public Student getStudent(int studentId) {
		Student s = new Student();
		
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getId() == studentId) {
				s = students.get(i);
			}
		}
		return s;
	}
	
	
	public boolean tryNewStudy(int studentId,int subjectId) {
		boolean success = false;
		Student s = this.getStudent(studentId);
		
		for(int i = 0; i <s.getNivel().getSubjectsAvailable().size();i++) {
			
			if(s.getNivel().getSubjectsAvailable().get(i).getId() == subjectId) {
				boolean hasSubject = false;
				for ( int j = 0; j < s.getSubjectsDone().size();j++) {
					if(s.getSubjectsDone().get(j).getId() == subjectId) {
						hasSubject = true;
					}
				}
				
				if(!hasSubject) 
					s.getSubjectsDone().add(s.getNivel().getSubjectsAvailable().get(i));
				
				success = true;
			}
		}
		
		return success;
	}
	
	public boolean tryUpgradeStudentNode(int studentId,int subjectId) {
		boolean success = false;
		Student s = this.getStudent(studentId);
		
		for(int i = 1; i <nodes.size();i++) {
			if(nodes.get(i).getSubjectsRequired().getId() == subjectId) {
				if(nodes.get(i).getId() != s.getNivel().getId()) {
					s.setNivel(nodes.get(i));
					success = true;
				}
			}
		}
		
		return success;
	}

	public Integer handleLoggin(int id,int password) {
		Integer tokkenResult = null; 

		if(id == -1 || password == -1) {
			return tokkenResult;
		}
		
		for ( int i = 0; i< this.getAllStudents().size();i++) {
			if(this.getAllStudents().get(i).getId() == id || this.getAllStudents().get(i).getPassword() == password) {
				tokkenResult = this.getAllStudents().get(i).getTokken();
			}
		}
		
		return tokkenResult;
	}
}

	
