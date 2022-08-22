import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//암호 만들기
public class BJ_1759 {
	static int L, C;
	static char[] arr;
	static char[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		selected = new char[L];
		
		input = br.readLine();
		st = new StringTokenizer(input, " ");
		
		int i=0;
		while(st.hasMoreTokens()) {
			arr[i] = st.nextToken().charAt(0);
			i++;
		}
		
		Arrays.sort(arr);
		
		comb(0, 0, 0, 0);
		
	}
	
	static void comb(int start, int cnt, int cntA, int cntB) {	//cntA - 모음 수, cntB - 자음 수
		if(cnt==L) {
			if(cntA >=1 && cntB >=2) {		//조건이 맞을때만 출력
				System.out.println(new String(selected));
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			char c = arr[i];
			selected[cnt] = c;
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
				comb(i+1, cnt+1, cntA+1, cntB);
			}
			else {
				comb(i+1, cnt+1, cntA, cntB+1);
			}
		}
	}

}