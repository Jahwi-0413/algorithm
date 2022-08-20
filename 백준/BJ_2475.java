import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//검증수
public class BJ_2475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int sum = 0;
		while(st.hasMoreTokens()) {
			int value = Integer.parseInt(st.nextToken());
			sum += value * value;
		}
		bw.write(sum%10 + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
