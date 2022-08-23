import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//스택
public class BJ_10828 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
			case "push":
				int value = Integer.parseInt(st.nextToken());
				stack.push(value);
				break;
			case "pop":
				if(stack.isEmpty())
					bw.write(-1 + "\n");
				else {
					value = stack.pop();
					bw.write(value + "\n");
				}
				break;
			case "size":
				bw.write(stack.size() + "\n");
				break;
			case "empty":
				if(stack.isEmpty())
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
				break;
			case "top":
				if(stack.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(stack.peek() + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
