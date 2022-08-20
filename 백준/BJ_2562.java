import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//최댓값
public class BJ_2562 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int max = 0;
		int maxIdx = 0;
		for(int i=0; i<9; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if(value > max) {
				max = value;
				maxIdx = i;
			}
		}
		
		bw.write(max + "\n" + (maxIdx+1));
		bw.flush();
		bw.close();
		br.close();
	}
}
