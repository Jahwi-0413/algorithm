import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//큐
public class BJ_10845 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		Deque<Integer> que = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
			case "push":
				int value = Integer.parseInt(st.nextToken());
				que.addLast(value);
				break;
			case "pop":
				if(que.isEmpty())
					bw.write(-1 + "\n");
				else {
					value = que.pollFirst();
					bw.write(value + "\n");
				}
				break;
			case "size":
				bw.write(que.size() + "\n");
				break;
			case "empty":
				if(que.isEmpty())
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
				break;
			case "front":
				if(que.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(que.peekFirst() + "\n");
				break;
			case "back":
				if(que.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(que.peekLast() + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
