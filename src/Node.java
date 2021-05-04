
public class Node {
	private int value;
	private Node nextNode;
	private NodeArray nextNodeArray;
	
	public Node(int val) {
		value = val;
	}
	
	public int getValue(){
		return value;
	}
	
	public Node getNextNode(){
		return nextNode;
	}
	
	public void setNextNode(Node n){
		nextNode = n;
	}
	
	public void setNextNodeArray(NodeArray na){
		nextNodeArray = na;
	}
	
	public NodeArray getNextNodeArray(){
		return nextNodeArray;
	}
}
