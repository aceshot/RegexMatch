package nfa;

import java.util.ArrayList;
import java.util.List;

import nfa.InputParams.Pair;

/**
 * 图
 * 代表有限自动机
 * start:起始点（初态）ID
 * end:终点(终态集)ID
 * 
 * @author Ace
 *
 */
public class Graph {
	private int start;
	private int end;
	private List<NodeEdge> nodeEdges;//点边集合（一个初始点+从该点射出的所有边）
	
	private Graph() {
		start = end = 0;
		nodeEdges = new ArrayList<>();
//		nodeEdges.add(new NodeEdge(new Node()));
	}
	private Graph(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public List<NodeEdge> getNodeEdges() {
		return nodeEdges;
	}
	public void setNodeEdges(List<NodeEdge> nodeEdges) {
		this.nodeEdges = nodeEdges;
	}
	
	/**
	 * 构建非确定性有限自动机
	 * @param ips 正则表达参数封装体
	 * @return
	 * @thanks 《编译原理》
	 */
	public static Graph buildGraph(InputParams ips){
		List<Pair> pairs = ips.getPairs();
		Graph g = new Graph();
//		Node start = g.getNodeEdges().get(0).getBeginNode();
		Node start = new Node(0);
		for(Pair pair:pairs){
			char ch = pair.getCharacter();
			char op = pair.getOpCode();
			start = buildGraph(g,start,ch,op);
		}
		return g;
	}
	private static Node buildGraph(Graph g, Node startNode, char ch, char op) {
		Node endNode = null;
		NodeEdge ne1 = null;
		NodeEdge ne2 = null;
		switch (op) {
		case '*':
			endNode = new Node(startNode.getNum()+1);
			if(null == startNode.getNodeEdge()){
				ne1 = new NodeEdge();
				ne1.setBeginNode(startNode);
				startNode.setNodeEdge(ne1);
				g.getNodeEdges().add(ne1);
			}else{
				ne1 = startNode.getNodeEdge();
			}
			if('.' == ch){
				ne1.getEdges().add(new Edge(endNode,Constants.ANY));
			}else{
				ne1.getEdges().add(new Edge(endNode,ch));
			}
			ne1.getEdges().add(new Edge(endNode, Constants.NONE));
			
			ne2 = new NodeEdge();
			ne2.setBeginNode(endNode);
			ne2.getEdges().add(new Edge(startNode, Constants.NONE));
			endNode.setNodeEdge(ne2);
			
			g.getNodeEdges().add(ne2);
			g.setEnd(endNode.getNum());
			break;
		case '+':
			endNode = new Node(startNode.getNum()+1);
			if(null == startNode.getNodeEdge()){
				ne1 = new NodeEdge();
				ne1.setBeginNode(startNode);
				startNode.setNodeEdge(ne1);
				g.getNodeEdges().add(ne1);
			}else{
				ne1 = startNode.getNodeEdge();
			}
			if('.' == ch){
				ne1.getEdges().add(new Edge(endNode,Constants.ANY));
			}else{
				ne1.getEdges().add(new Edge(endNode,ch));
			}
			
			ne2 = new NodeEdge();
			ne2.setBeginNode(endNode);
			ne2.getEdges().add(new Edge(startNode, Constants.NONE));
			endNode.setNodeEdge(ne2);
			
			g.getNodeEdges().add(ne2);
			g.setEnd(endNode.getNum());
			break;
		case '?':
			endNode = new Node(startNode.getNum()+1);
			if(null == startNode.getNodeEdge()){
				ne1 = new NodeEdge();
				ne1.setBeginNode(startNode);
				startNode.setNodeEdge(ne1);
				g.getNodeEdges().add(ne1);
			}else{
				ne1 = startNode.getNodeEdge();
			}
			if('.' == ch){
				ne1.getEdges().add(new Edge(endNode,Constants.ANY));
			}else{
				ne1.getEdges().add(new Edge(endNode,ch));
			}
			ne1.getEdges().add(new Edge(endNode, Constants.NONE));
			g.setEnd(endNode.getNum());
			break;
		default:
			endNode = new Node(startNode.getNum()+1);
			if(null == startNode.getNodeEdge()){
				ne1 = new NodeEdge();
				ne1.setBeginNode(startNode);
				startNode.setNodeEdge(ne1);
				g.getNodeEdges().add(ne1);
			}else{
				ne1 = startNode.getNodeEdge();
			}
			if('.' == ch){
				ne1.getEdges().add(new Edge(endNode,Constants.ANY));
			}else{
				ne1.getEdges().add(new Edge(endNode,ch));
			}
			g.setEnd(endNode.getNum());
			break;
		}
		return endNode;
	}
}
