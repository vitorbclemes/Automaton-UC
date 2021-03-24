package org.enoir.graphvizapi;

import data.Nodo;

/**
 * The Node class like Graphviz's node.
 * Created by frank on 2014/11/17.
 */
public class Node extends BaseGraphObject {
	
	public Nodo nodo;

    /**
     * Constructor.
     * @param id
     */
    public Node(String id, Nodo nodo) {
        super(id);
        this.nodo = nodo;
    }

    public Nodo getNodo() {
		return nodo;
	}

	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}

	@Override
    public String genDotString() {
        StringBuilder dotString = new StringBuilder();
        dotString.append("["+this.genAttributeDotString()+"]");
        return dotString.toString();
    }
}
