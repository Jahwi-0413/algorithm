import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//나무 자르기
public class BJ_2805 {
	static int N;
	static long M, max, min, res;
	static long[] trees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		max = Long.MIN_VALUE;
		min = 0;
		
		trees = new long[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(st.nextToken());
			trees[i] = value;
			if(max < value) max = value;
		}
		
		binarySearch(min, max);
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void binarySearch(long left, long right) {
		if(left>right) {		//못찾음
			return;
		}
		
		long middle = (right+left)/2;
		long cut = getTreesHeight(middle);
		
		if(cut==M) {
			res = middle;
		}
		else if(cut >= M) {	//목표량보다 많음 -> 컷팅기 높이를 높임
			res = middle;		//최대한의 높이 갱신
			binarySearch(middle+1, right);
		}
		else{			//목표량보다 적음 -> 컷팅기 높이를 낮춤
			binarySearch(left, middle-1);
		}
		
	}
	static long getTreesHeight(long cutting) {
		long sum = 0;
		for(int i=0; i<N; i++) {
			if(trees[i] > cutting) sum += trees[i] - cutting;
		}
		return sum;
	}
}
