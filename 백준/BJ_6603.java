import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//로또
public class BJ_6603 {
	static int K;
	static int[] arr;
	static int[] selected;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		String input = br.readLine();
		while(true) {
			StringTokenizer st = new StringTokenizer(input, " ");

			K = Integer.parseInt(st.nextToken());
			arr = new int[K];
			selected = new int[6];
			
			for(int i=0; i<K; i++) {
				int value = Integer.parseInt(st.nextToken());
				arr[i] = value;
			}
			Arrays.sort(arr);
			comb(0, 0);
			input = br.readLine();
			
			if(!input.equals("0")) {
				sb.append("\n");
			}
			else {
				break;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void comb(int depth, int start) {
		if(depth==6) {
			for(int i=0; i<6; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<K; i++) {
			selected[depth] = arr[i];
			comb(depth+1, i+1);
		}
	}
}
