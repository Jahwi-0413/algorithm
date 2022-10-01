import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//수들의 합 2
public class BJ_2003 {
	static int N, left, right, cnt;
	static long M;
	static List<Integer> arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		arr = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(st.nextToken());
			arr.add(value);
		}
		
		long sum = arr.get(0);
		boolean isRightEnd = false;
		
		while(true) {
			if(left==N-1 && right==N-1) {
				if(arr.get(left)==M) cnt++;
				break;
			} 
			
			if(!isRightEnd && right==N-1) {
				isRightEnd = true;
			}
			
			if(!isRightEnd) {		//right가 마지막 index가 아니라면
				if(sum < M) {
					sum += arr.get(++right);
					continue;
				}
				if(sum > M) {
					sum -= arr.get(left++);
					continue;
				} 
				if(sum==M) {
					cnt++;
					sum += arr.get(++right);
				}
			}
			else {		//right가 마지막 index라면 left만 움직여준다
				if(sum==M) {
					cnt++;
					sum -= arr.get(left++);
				}
				else {
					sum -= arr.get(left++);
				}
			}
		}//end of while
		
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
