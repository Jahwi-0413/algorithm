import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//통계학
public class BJ_2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(br.readLine());
			arr[i] = value;
			
			sum+= value;
		}
		
		Arrays.sort(arr);
		
		int count = 0;
		int modMax = -1;
		int mod = arr[0];
		boolean check = false;

		for(int i = 0; i < N - 1; i++) {	//최빈값
			if(arr[i] == arr[i + 1]) {
				count++;
			}else {
				count = 0;
			}
			
			if(modMax < count) {
				modMax = count;
				mod = arr[i];
				check = true;
			}else if(modMax == count && check == true) {
				mod = arr[i];
				check = false;
			}
		}
		
		bw.write(Math.round((double)sum/N) +"\n");		//산술평균
		bw.write(arr[N/2] + "\n");	//중앙값
		bw.write(mod + "\n");		//최빈값
		int min = arr[0];
		int max = arr[N-1];
		bw.write(max-min + "");		//범위
		
		bw.flush();
		bw.close();
		br.close();
	}
}
