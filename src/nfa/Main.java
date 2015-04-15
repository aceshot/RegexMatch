package nfa;

import java.util.List;

import nfa.InputParams.Pair;

public class Main {

	public static void main(String[] args) {
		String regex = "ab*d?s.d+f";
		//拆分正则表达式到自定义数据结构InputParams中
		InputParams ips = new InputParams(regex);
		for(Pair pair:ips.getPairs()){
			System.out.println(pair);
		}
		//构建非确定性有限自动机->状态图(具体理论知识参考编译原理相关书籍)
		Graph g = Graph.buildGraph(ips);
		List<NodeEdge> noedEdges = g.getNodeEdges();
		//测试输出图结构
		//输出结构为：Node（i）
		/**
		 * 测试输出图结构
		 * 输出结构为：
		 * Node：i
		 * value
		 * 
		 * 表示
		 * 以第i个节点为开始节点的所有边上的输入字符
		 */
		for(NodeEdge ne:noedEdges){
			System.out.println("Node："+ne.getBeginNode().getNum());
			for(Edge e:ne.getEdges()){
				System.out.println(e.getInput());
			}
		}
		String []dest = {"abdsddddddf","abdds","adsdf"};
		System.out.println("正则:"+regex);
		for(String str:dest){
		System.out.println("字符串："+str+"\n是否匹配："+Matches.regexMatch(g,str));	
		}
	}

}
