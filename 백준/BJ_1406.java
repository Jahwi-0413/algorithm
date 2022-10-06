import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

//에디터
public class BJ_1406 {
	static Deque<Character> left, right;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		left = new ArrayDeque<>();
		right = new ArrayDeque<>();
		char[] input = br.readLine().toCharArray();
		for(int i=0,size=input.length; i<size; i++) {
			left.add(input[i]);
		}
		
		int cnt = Integer.parseInt(br.readLine());
		for(int i=0; i<cnt ; i++) {	//명령어 처리
			input = br.readLine().toCharArray();
			switch(input[0]) {
			case 'L': moveLeft(); 			break;
			case 'D': moveRight(); 			break;
			case 'B': deleteLeft();			break;
			case 'P': appendLeft(input[2]);break;
			}
		}
		
		while(!left.isEmpty()) {
			bw.write(left.pollFirst());
		}

		while(!right.isEmpty()) {
			bw.write(right.pollFirst());
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void moveLeft() {
		if(left.isEmpty()) return;
		char c = left.pollLast();
		right.addFirst(c);
	}
	
	static void moveRight() {
		if(right.isEmpty()) return;
		char c = right.pollFirst();
		left.addLast(c);
	}
	
	static void deleteLeft() {
		if(left.isEmpty()) return;
		left.pollLast();
	}
	
	static void appendLeft(char c) {
		left.addLast(c);
	}
}