import java.io.BufferedInputStream;
import java.io.IOException;

public class LZencode {
	
	int counter = 0;
	NodeArray dictionary = new NodeArray(counter);
	int _byte;
	BufferedInputStream buffis;
	
	
	public static void main(String[] args) throws IOException {
		LZencode encode = new LZencode();
		encode.run();
	}
	
	public void run() throws IOException {
		buffis = new BufferedInputStream(System.in);
		_byte = buffis.read();
		while(_byte != -1) {
			searchNodeArray(dictionary, _byte);
			//go through the dict, check if a letter exists
			//if it doesn't create a node 
			//if it does go to the node array it links to.
			//repeat until node is found.
		}
		System.out.println("-------");
		for(int j = 0; j < dictionary.nodes.length; j++) {
			System.out.println((char)dictionary.nodes[j].getValue());
		}
		System.out.println("-------");
	}
	
	public void searchNodeArray(NodeArray na, int b) throws IOException {
		for(int i = 0; i < na.nodes.length; i ++) {
			if(na.nodes[i].getValue() == _byte) {
				_byte = buffis.read();
				if (_byte == -1) {
					return;
				}
				searchNodeArray(na.nodes[i].getNextNodeArray(), _byte);
				return;
				//get next byte and try again
			}
		}
		NodeArray newNA = new NodeArray(counter);
		Node n = new Node((char)b);
		na.add(n);
		n.setNextNodeArray(newNA);
		System.out.println(counter + " " + (char)b); 
		counter++;
		_byte = (char)buffis.read();
		return;
	}
}
