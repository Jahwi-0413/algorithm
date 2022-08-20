import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//아스키 코드
public class BJ_11654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char input =br.readLine().charAt(0);
		
		bw.write((int)input + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
