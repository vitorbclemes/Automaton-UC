package data;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.enoir.graphvizapi.*;

public class Automaton {
	private int id;
	private Student student;
	private static String tmpPath = "automaton/";
	private static String absoluteTestPath = new File(tmpPath).getAbsolutePath();
	private Nodo currentState;
	
	//Mealy Machine
	public ArrayList<Nodo> nodes;
	private Nodo initialState;
	private ArrayList<Subject> inputAlphabet;
	private ArrayList<Subject> outputAlphabet;
	

	public Automaton(int id,Student std,ArrayList<Nodo> ns, ArrayList<Subject> alphabetI, ArrayList<Subject> alphabetO) {
		this.setId(id);
		this.setStudent(std);
		
		//Mealy Machine
		this.setNodes(ns);
		this.setInputAlphabet(alphabetI);
		this.setOutputAlphabet(alphabetO);
		this.initialState = nodes.get(0);
	}
	
	public String programFunction(Automaton automaton, Subject subject) {
		this.currentState = currentState;
		return "Done";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student newStudent) {
		this.student = newStudent;
	}
	public ArrayList<Nodo> getNodes() {
		return nodes;
	}
	public void setNodes(ArrayList<Nodo> newNodes) {
		this.nodes = newNodes;
	}
	
	public ArrayList<Subject> getInputAlphabet() {
		return inputAlphabet;
	}
	
	public void setInputAlphabet(ArrayList<Subject> newInputAlphabet) {
		this.inputAlphabet = newInputAlphabet;
	}
	
	public ArrayList<Subject> getOutputAlphabet() {
		return outputAlphabet;
	}
	
	public void setOutputAlphabet(ArrayList<Subject> newOutputAlphabet) {
		this.outputAlphabet = newOutputAlphabet;
	}
	
	public void draw()
    {
        Graphviz gv = new Graphviz();
        Graph graph = new Graph("g1", GraphType.DIGRAPH);
        graph.addAttribute(new Attribute("rankdir", "LR"));
        
        for(int i=0;i<nodes.size();i++) {
        	String nodeLabel = Integer.toString(nodes.get(i).getId());
        	
        	Node newGraphNode = new Node(nodeLabel, nodes.get(i));
        	if(i==0)
        		newGraphNode.addAttribute(new Attribute("label", "\" -> Inicial \""));

        	if(nodes.get(i).getId() == this.student.getNivel().getId()) {
        		newGraphNode.addAttribute( new Attribute("style", "filled") );
        		newGraphNode.addAttribute( new Attribute("color", "green") );
        	}
        	
        	graph.addNode(newGraphNode);
        }
        
        List<Node> graphNodes = graph.getNodes();
        
        for(Node node1:graphNodes) {
        	if(node1.getNodo().getExtraSubject() != null) {
        		for(Subject s:node1.getNodo().getExtraSubject()) {
        			Edge newEdge = new Edge("", node1, node1);
            		newEdge.addAttribute( new Attribute("label", " \" " + s.getId() + " : " + s.getLink()  + " \"") );
            		graph.addEdge( newEdge);
        		}
        	}
        	for(Node node2:graphNodes) {
        		if(node2.getNodo().getId()==0) {
        			continue;
        		}
        		Edge newEdge = new Edge("", node1, node2);
        		newEdge.addAttribute( new Attribute("label", " \" " + node2.getNodo().getSubjectsRequired().getId() + " : " + node2.getNodo().getSubjectsRequired().getLink()  + " \"") );
        		graph.addEdge( newEdge);
        	}
        }

        String type = "png";
        File out = new File(absoluteTestPath+"/progessoAluno"+student.getId() + "." + type);
        this.writeGraphToFile( gv.getGraphByteArray(graph, type, "100"), out );
    }
	
	private int writeGraphToFile(byte[] img, File to)
    {
        try {
            FileOutputStream fos = new FileOutputStream(to);
            fos.write(img);
            fos.close();
        } catch (java.io.IOException ioe) { return -1; }
        return 1;
    }
	
}