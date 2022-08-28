import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//요세푸스 문제 0
public class BJ_11866 {
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		while(true) {
			for(int i=0; i<K-1; i++) {
				int value = q.poll();
				q.offer(value);
			}
			int value = q.poll();	//k번째
			sb.append(value);
			if(!q.isEmpty()) {
				sb.append(", ");
			}
			else {
				sb.append(">");
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
