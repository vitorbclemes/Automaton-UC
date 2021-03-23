package data;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.enoir.graphvizapi.*;

public class Automaton {
	private int id;
	public ArrayList<Nodo> nodes;
	private Student student;
	private static String tmpPath = "/home/pedro/Imagens/img_lfa";

	public Automaton(int id,Student std,ArrayList<Nodo> ns) {
		this.setId(id);
		this.setStudent(std);
		this.setNodes(ns);
		this.draw();
	}
	
	public Automaton(int id) {
		this.setId(id);
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
	
	private void draw()
    {
		System.out.println("JOÃOZINHO");
        Graphviz gv = new Graphviz();
        Graph graph = new Graph("g1", GraphType.DIGRAPH);
        graph.addAttribute(new Attribute("rankdir", "LR"));
        
        for(int i=0;i<nodes.size();i++) {
        	String nodeLabel = Integer.toString(nodes.get(i).getId());
        	Node newGraphNode = new Node(nodeLabel);
//        	newGraphNode.addAttribute( new Attribute("label", nodes.get(i).getSubjectsRequired().getLabel()));
//        	newGraphNode.addAttribute( new Attribute("label", "\"  \""));
        	if(nodes.get(i).getId() == this.student.getNivel().getId()) {
        		newGraphNode.addAttribute( new Attribute("style", "filled") );
        		newGraphNode.addAttribute( new Attribute("color", "green") );
        		newGraphNode.addAttribute(new Attribute("label","\" Estado atual \""));
        	}
        	graph.addNode(newGraphNode);
        }
        
        List<Node> graphNodes = graph.getNodes();
        
        for(Node node1:graphNodes) {
        	Nodo currentNode = student.getNivel();
//        	for(int i=0;i<currentNode.getSubjectsAvailable().size();i++) {
//        		if(!currentNode.getSubjectsAvailable().get(i).isMandatory()) {        			
//        			Node newSideNode = new Node("Saco");
//        			System.out.println(currentNode.getSubjectsAvailable().get(i).toString());
//        			newSideNode.addAttribute( new Attribute("style", "filled") );
//        			newSideNode.addAttribute( new Attribute("color", "yellow") );
//        			graph.addEdge( new Edge("", node1, newSideNode));
//        		}
//        	}
        	for(Node node2:graphNodes) {
        		graph.addEdge( new Edge("", node1, node2));
        	}
        }


//        Node n1 = new Node("N1");
//        n1.addAttribute(new Attribute("label", "\" Node1 \""));
//        Node n2 = new Node("N2");
//        Node n3 = new Node("N3");
//        graph.addNode(n1);
//        graph.addNode(n2);
//        graph.addNode(n3);
//        graph.addEdge(new Edge("", n1, n2));
//        graph.addEdge(new Edge("", n2, n3));
//        graph.addEdge(new Edge("",n3,n1));


        String type = "png";

        File out = new File(tmpPath+"/outEX1."+ type);
        this.writeGraphToFile( gv.getGraphByteArray(graph, type, "100"), out );
    }
	
	public int writeGraphToFile(byte[] img, File to)
    {
        try {
            FileOutputStream fos = new FileOutputStream(to);
            fos.write(img);
            fos.close();
        } catch (java.io.IOException ioe) { return -1; }
        return 1;
    }
	
}