import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//카드 정렬하기
public class BJ_1715 {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			pq.add(value);
		}
		
		int sum = 0;
		
		while(pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			
			sum += a + b;
			pq.add(a + b);
		}
		
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
