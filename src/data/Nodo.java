package data;
import java.util.ArrayList;

public class Nodo {
	private int id;
	private Subject subjectRequired;
	private ArrayList<Subject> subjectsAvailable;
	private ArrayList<Subject> extraSubject;

	public Nodo(int id,Subject sr,ArrayList<Subject> sa, ArrayList<Subject> ex) {
		this.setId(id);
		this.setSubjectsRequired(sr);
		this.setSubjectsAvailable(sa);
		this.setExtraSubject(ex);
	}
	
	public Nodo(int id,Subject sr,ArrayList<Subject> sa) {
		this.setId(id);
		this.setSubjectsRequired(sr);
		this.setSubjectsAvailable(sa);
	}
	
	public Nodo(int id) {
		this.setId(id);
	}
	
	public ArrayList<Subject> getExtraSubject() {
		return extraSubject;
	}

	public void setExtraSubject(ArrayList<Subject> extraSubject) {
		this.extraSubject = extraSubject;
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

