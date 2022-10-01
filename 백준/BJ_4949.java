import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//균형잡힌 세상
public class BJ_4949 {
	static char type1 = '[', type2='(';
	static char type1Pair = ']', type2Pair = ')';
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		while(!input.equals(".")) {
			char[] arr = input.toCharArray();
			Stack<Character> stack = new Stack<>();
			boolean isRight = true;
			
			for(int i=0,size=arr.length; i<size; i++) {
				char c = input.charAt(i);
				if(c==type1 || c==type2 || c==type1Pair || c==type2Pair) {
					if(c==type1 || c==type2) {
						stack.push(c);
						continue;
					}
					
					if(stack.isEmpty()) {		//스택에 아무것도 없는데 짝을 맞춰야 한다면 No
						isRight = false;
						break;
					}
					char top = stack.pop();
					if((c==type1Pair && top==type1) || (c==type2Pair && top==type2)) {	 //짝이 맞을 경우
						continue;
					}
					else {			//짝이 맞지 않을 경우
						isRight = false;
						break;
					}
				}
			}
			
			if(isRight && stack.isEmpty()) bw.write("yes\n");
			else bw.write("no\n");
			input = br.readLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
