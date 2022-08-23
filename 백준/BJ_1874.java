import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//수열
public class BJ_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		
		StringBuilder sb = new StringBuilder();
		boolean result = true;
		boolean[] visited = new boolean[N+1];

		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(br.readLine());
			if(value==num) {
				sb.append("+\n-\n");	//넣어야 하는 수와 빼야하는 수가 같은 경우
				 num++;
				 continue;
			}
			
			while(true) {
				if(stack.isEmpty()) {	//스택이 비어있으면 일단 넣어줌
					stack.push(num);
					sb.append("+\n");
					visited[num++] = true;
					continue;
				}
				
				int peek = stack.peek();
				if(value==peek) {
					stack.pop();
					sb.append("-\n");
					break;
				}
				
				if(visited[value]) {
					result = false;
					break;
				}
				
				stack.push(num);
				visited[num++] = true;
				sb.append("+\n");
			}
		}
		
		if(!result) {
			bw.write("NO");
		}
		else {
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}