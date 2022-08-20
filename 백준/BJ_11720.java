import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//숫자들의 합
public class BJ_11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		
		String input = br.readLine();
		
		int sum = 0;
		for(int i=0; i<size; i++) {
			sum += input.charAt(i) - '0';
		}
		
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
