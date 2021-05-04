import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class LZdecode {
	
	BufferedInputStream buffis;
	int _byte;
	int[] count = {-1};
	int[] letter = {0};
	String line;
	
	public static void main(String[] args) throws IOException {
		LZdecode decode = new LZdecode();
		decode.run();
	}
	
	public void run() throws IOException {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			line = sc.nextLine();
			String[] lineSplit = line.split(" ");
			count = addToArr(lineSplit[0], count);
			letter = addToArr(lineSplit[1], letter);
			printChar(Integer.parseInt(lineSplit[0]), Integer.parseInt(lineSplit[1]));
		}
	}
	
	public int[] addToArr(String item, int[] arr) {
		int[] temp = arr;
		arr = new int[temp.length + 1];
		for(int i = 0; i < temp.length; i++) {
			arr[i] = temp[i];
		}
		arr[arr.length - 1] = Integer.parseInt(item);
		return arr;
	}
	
	public void printChar(int n, int c) {
		if (count[n] == -1) {
			System.out.print((char)c );
			return;
		}
		int num = count[n];
		printChar(num, letter[n]);
		System.out.print((char)c);
		return;
	}
}
