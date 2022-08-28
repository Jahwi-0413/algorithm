import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

//최소 힙
public class BJ_1927 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new PriorityQueue<>((a, b) -> a-b);
		
		for(int i=0; i<N; i++) {
			int number = Integer.parseInt(br.readLine());
			if(number==0) {
				if(q.isEmpty()) {
					bw.write(0 + "\n");
					continue;
				} 
				int poll = q.poll();
				bw.write(poll + "\n");
			}
			else {
				q.add(number);
			}
			
		}
		bw.flush();
		bw.close();
	}
}