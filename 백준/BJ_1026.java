import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//보물
public class BJ_1026 {
	static int N;
	static int[] aNums;
	static int[] bNums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		aNums = new int[N];
		bNums = new int[N];
		
		PriorityQueue<Integer> asc = new PriorityQueue<>();		//오름차순
		PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			aNums[i] = value;
			asc.add(aNums[i]);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			bNums[i] = value;
			desc.add(bNums[i]);
		}
		
		int minRes = Integer.MAX_VALUE;
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			int num1 = asc.poll();
			int num2 = desc.poll();
			sum += num1 * num2;
		}
		minRes = Math.min(minRes, sum);
		
		for(int i=0; i<N; i++) {			//오름, 내림 바꿔서 계산
			desc.add(aNums[i]);
			asc.add(bNums[i]);
		}
		
		sum = 0;
		for(int i=0; i<N; i++) {
			int num1 = asc.poll();
			int num2 = desc.poll();
			sum += num1 * num2;
		}
		minRes = Math.min(minRes, sum);
		
		bw.write(minRes + "");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
