package nfa;
/**
 * 图中边
 * input:代表有穷字母表的一个输入字符
 * endNode:代表有向边的终点
 * @author Ace
 *
 */
public class Edge implements Comparable<Edge>{
	private Node endNode;
	private char input;
	
	public Edge() {
	}
	public Edge(Node endNode, char input) {
		this.endNode = endNode;
		this.input = input;
	}
	public Node getEndNode() {
		return endNode;
	}
	public void setEndNode(Node endNode) {
		this.endNode = endNode;
	}
	public char getInput() {
		return input;
	}
	public void setInput(char input) {
		this.input = input;
	}
	@Override
	public int compareTo(Edge paramT) {
		return -paramT.getInput()+input;
	}
	
}
