import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//한수
public class BJ_1065 {
	static int N, res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			if(isOneNum(i)) res++;
		}
		
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean isOneNum(int num) {
		String str = Integer.toString(num);
		int size = str.length();
		if(size <= 1) return true;
		
		int first = str.charAt(0) - '0';
		int second = str.charAt(1) - '0';
		
		int diff = second - first;
		int now = second;
		
		for(int i=1; i<size-1; i++) {			//next - now => diff
			int next = str.charAt(i+1) -'0';
			int d = next-now;
			if(d!=diff) return false;		//등차수열 아님
			now = next;
		}
		return true;
	}
}
