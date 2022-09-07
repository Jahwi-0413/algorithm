import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

//국회의원 선거
public class BJ_1417 {
	static int N, dasom, res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		dasom = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=1; i<N; i++) {
			int value = Integer.parseInt(br.readLine());
			if(dasom <= value) {
				q.offer(value);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now >= dasom) {
				res++;
				now--;
				dasom++;
				q.offer(now);
			}
		}
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
