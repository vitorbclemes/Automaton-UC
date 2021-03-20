package data;

public class Subject {
	
	private int id;
	private String label;
	private boolean mandatory;
	
	
	
	public Subject(int id, String label, boolean mandatory) {
		super();
		this.id = id;
		this.label = label;
		this.mandatory = mandatory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public boolean isMandatory() {
		return mandatory;
	}
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	@Override
	public String toString() {
		return "Id : " + id + ", Nome : " + label + "";
	}
	
	
	
	
}
