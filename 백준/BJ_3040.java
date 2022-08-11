import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백설 공주와 일곱 난쟁이
public class BJ_3040 {
	static int[] dwarfs = new int[9];
	static int[] realDwarfs = new int[7];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0,0);
	}
	
	static void comb(int cnt, int start, int sum) {
		if(sum>100) return;
		if(cnt==7) {
			if(sum==100) {
				for(int i=0; i<7; i++) {
					System.out.println(realDwarfs[i]);
				}
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			realDwarfs[cnt] = dwarfs[i];
			comb(cnt+1, i+1, sum + dwarfs[i]);
		}
	}
}
