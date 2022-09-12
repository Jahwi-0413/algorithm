import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//랜선 자르기
public class BJ_1654 {
	static int N, M;
	static long res = 0;
	static long[] lans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lans = new long[N];
		int max = 0;
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(br.readLine());
			lans[i] = value;
			if(max < value) max = value;
		}
		
		binarySearch(1, max);		//1부터 시작하는 이유는 divide by zero를 피하기 위해서
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void binarySearch(long left, long right) {	//right가 integer.max_value면 +1시 overflow -> long으로
		if(left > right) return;

		long middle = (left + right)/2;

		int lanCnt = cutLans(middle);
		if(lanCnt < M) binarySearch(left, middle-1);
		else {
			res = middle;
			binarySearch(middle+1, right);	
		}
	}
	
	static int cutLans(long length) {
		int sum = 0;
		
		for (int i = 0; i < lans.length; i++) {
			sum += lans[i]/length;
		}
		return sum;
	}
}
