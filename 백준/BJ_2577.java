import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//숫자의 개수
public class BJ_2577 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] numUsed = new int[10];

		int result = 1;
		for (int i = 0; i < 3; i++) {
			int num = Integer.parseInt(br.readLine());
			result *= num;
		}

		String num = Integer.toString(result);
		for (int i = 0, size = num.length(); i < size; i++) {
			int value = num.charAt(i)-'0';
			numUsed[value]++;
		}
		
		for(int i=0; i<10; i++) {
			bw.write(numUsed[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
