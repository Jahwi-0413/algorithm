import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//수 정렬하기2
public class BJ_2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int size = Integer.parseInt(br.readLine());
		
		for(int i=0; i<size; i++) {
			int value = Integer.parseInt(br.readLine());
			
			pq.add(value);
		}
		
		while(!pq.isEmpty()) {
			int value = pq.poll();
			bw.write(value + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
