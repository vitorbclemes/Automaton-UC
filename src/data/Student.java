package data;
import java.util.ArrayList;

public class Student {
	private int id;
	private int password;
	private Integer tokken;
	private String name;
	private Nodo nivel;
	private ArrayList<Subject> subjectsDone;
	
	public Student(int id, int password, String name,Integer tokken,ArrayList<Subject> sd) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.tokken = tokken;
		this.subjectsDone=sd;
	}
	
	public Student () {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Nodo getNivel() {
		return nivel;
	}
	public void setNivel(Nodo nivel) {
		this.nivel = nivel;
	}
	public ArrayList<Subject> getSubjectsDone() {
		return subjectsDone;
	}
	public void setSubjectsDone(ArrayList<Subject> subjectsDone) {
		this.subjectsDone = subjectsDone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public Integer getTokken() {
		return tokken;
	}

	public void setTokken(Integer tokken) {
		this.tokken = tokken;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return " - Id :" +id + " \n - Nome : " + name + "\n - Nivel : " + nivel.getId() + "\n Assunto atual : " + nivel.getSubjectsRequired().getLabel();
	}
	
	
	
}
