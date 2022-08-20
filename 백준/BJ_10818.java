import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//최소, 최대
public class BJ_10818 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size = Integer.parseInt(br.readLine());
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		for(int i=0; i<size; i++) {
			int value = Integer.parseInt(st.nextToken());
			max = Math.max(max, value);
			min = Math.min(min, value);
		}
		
		bw.write(min + " " + max);
		bw.flush();
		bw.close();
		br.close();
	}
}
