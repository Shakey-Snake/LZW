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
		}
		/*System.out.println("-------");
		for(int j = 0; j < dictionary.nodes.length; j++) {
			System.out.println((char)dictionary.nodes[j].getValue());
		}
		System.out.println("-------");*/
	}
	
	public void searchNodeArray(NodeArray na, int b) throws IOException {
		for(int i = 0; i < na.nodes.length; i ++) {
			if(na.nodes[i].getValue() == _byte) {
				if (_byte == -1) {
					return;
				}
				/*if (na.nodes[i].getNextNodeArray() == null) {
					_byte = buffis.read();
					if(_byte == -1) {
						return;
					}
					counter++;
					NodeArray newNA = new NodeArray(counter);
					na.nodes[i].setNextNodeArray(newNA);
					Node n = new Node(_byte);
					newNA.add(n);
					System.out.println(newNA._number + " " + _byte);
					_byte = buffis.read();
					return;
				}*/
				_byte = buffis.read();
				searchNodeArray(na.nodes[i].getNextNodeArray(), _byte);
				return;
			}
		}
		Node n = new Node(b);
		counter++;
		NodeArray newNA = new NodeArray(counter);
		n.setNextNodeArray(newNA);
		na.add(n);
		System.out.println(na._number + " " + /*(char)*/b);
		_byte = buffis.read();
		return;
	}
}