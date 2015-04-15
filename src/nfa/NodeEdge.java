package nfa;

import java.util.ArrayList;
import java.util.List;
/**
 * 点边集合
 * beginNode:代表某个起点
 * edges:代表由beginNode射出的边的集合
 * @author Ace
 *
 */

public class NodeEdge {
	private Node beginNode;
	private List<Edge> edges;
	
	public NodeEdge(){
		edges = new ArrayList<Edge>();
	}
	
	public NodeEdge(Node beginNode) {
		this.beginNode = beginNode;
	}

	public Node getBeginNode() {
		return beginNode;
	}
	public void setBeginNode(Node beginNode) {
		this.beginNode = beginNode;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
}
