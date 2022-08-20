import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//A+B-4
public class BJ_10951 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input =br.readLine();
		while(input!=null) {
			StringTokenizer st = new StringTokenizer(input, " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			bw.write((a + b) + "\n");
			input = br.readLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

//ctl + z -> 입력 종료