import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//중복 빼고 정렬하기
public class BJ_10867 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		Set<Integer> numbers = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			numbers.add(value);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=-1000; i<=1000; i++) {
			if(numbers.contains(i))
				sb.append(i + " ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
