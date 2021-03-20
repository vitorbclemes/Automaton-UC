package data;
import java.util.ArrayList;

public class Node {
	private int id;
	private Subject subjectRequired;
	private ArrayList<Subject> subjectsAvailable;

	public Node(int id,Subject sr,ArrayList<Subject> sa) {
		this.setId(id);
		this.setSubjectsRequired(sr);
		this.setSubjectsAvailable(sa);
	}
	
	public Node(int id) {
		this.setId(id);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Subject getSubjectsRequired() {
		return subjectRequired;
	}
	public void setSubjectsRequired(Subject subjectsRequired) {
		this.subjectRequired = subjectsRequired;
	}
	public ArrayList<Subject> getSubjectsAvailable() {
		return subjectsAvailable;
	}
	public void setSubjectsAvailable(ArrayList<Subject> subjectsAvailable) {
		this.subjectsAvailable = subjectsAvailable;
	}	
}

