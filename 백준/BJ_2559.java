import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//수열
public class BJ_2559 {
	static int N, K, max=Integer.MIN_VALUE, sum;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(i<K) {
				sum += arr[i];
			}
		}
		
		int left = 0, right = K-1;
		while(true) {
			max = Math.max(max, sum);
			
			sum -= arr[left++];
			if(right < N-1) {
				sum += arr[++right];
			}
			else {
				break;
			}
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
