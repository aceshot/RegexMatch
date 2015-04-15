package nfa;

import java.util.Collections;
import java.util.List;

public class Matches {
	public static boolean regexMatch(Graph g, String dest){
		int end = g.getEnd();
		return dfs(g.getNodeEdges().get(0),end,dest,0,0);
	}
	
	private static boolean dfs(NodeEdge startNode, int end, String dest,int at,int depth){
		if(at == dest.length() && depth == end){
//			System.out.println("success");
			return true;
		}
		if(at == dest.length() || depth == end){
			return false;
		}
		List<Edge> edges = startNode.getEdges();
		Collections.sort(edges);
		for(Edge e:edges){
			Node n = e.getEndNode();
			if(dest.charAt(at) == e.getInput()){
				at++;
				if(!dfs(n.getNodeEdge(),end,dest,at,n.getNum())){
					at--;
					return false;
				}else{
					return true;
				}
			}else if(e.getInput() == Constants.ANY){
				at++;
				if(!dfs(n.getNodeEdge(),end,dest,at,n.getNum())){
					at--;
					return false;
				}else{
					return true;
				}
			}else if(e.getInput() == Constants.NONE){
				return dfs(n.getNodeEdge(),end,dest,at,n.getNum());
			}
		}
		return false;
	}
}
