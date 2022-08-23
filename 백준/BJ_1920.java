import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//수 찾기
public class BJ_1920 {
	static int N, M;
	static Map<Integer, Integer> arr = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(st.nextToken());
			arr.put(value, 0);
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			if(arr.get(value)!=null) {	//수열 N에 있는지 확인
				bw.write(1 + "\n");
			}
			else {
				bw.write(0 + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
