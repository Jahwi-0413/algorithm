import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//부분순열의 합
public class BJ_1182 {
	static int N, S, result;
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		input = new int[N];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		subset(0, 0);
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void subset(int cnt, int sum) {
		if(cnt==N) {
			boolean isEmpty = true;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					isEmpty = false;
					break;
				}
			}
			if(S==sum && !isEmpty){
				result++;
			}
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1, sum + input[cnt]);		//선택 O
		
		isSelected[cnt] = false;
		subset(cnt+1, sum);						//선택 X
	}
}
