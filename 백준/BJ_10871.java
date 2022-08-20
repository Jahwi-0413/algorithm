import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//X보다 작은 수
public class BJ_10871 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		input = br.readLine();
		st = new StringTokenizer(input, " ");
		
		int[] arr = new int[N];
		int cnt = 0;
		while(st.hasMoreTokens()) {
			int value = Integer.parseInt(st.nextToken());
			if(value < X) {
				arr[cnt++] = value;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<cnt; i++) {
			sb.append(arr[i] + " ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
