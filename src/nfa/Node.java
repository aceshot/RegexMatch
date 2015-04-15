package nfa;
/**
 * 图节点
 * 代表有限集的一个状态
 * @author Ace
 *
 */
public class Node {
	private int num;//状态ID
	private NodeEdge nodeEdge;//指向其所属的点边集合（类似于子节点指向父节点）
	
	public Node(){
		num = 0;
	}
	public Node(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public NodeEdge getNodeEdge() {
		return nodeEdge;
	}
	public void setNodeEdge(NodeEdge nodeEdge) {
		this.nodeEdge = nodeEdge;
	}
	
}
