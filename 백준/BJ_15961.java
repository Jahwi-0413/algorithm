import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//회전 초밥
public class BJ_15961 {
	static int N, D, K, C, left, right, result;
	static int[] susiArr;
	static Map<Integer, Integer> kCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		left = 0; right = K-1;
		
		susiArr = new int[N];
		kCnt = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			susiArr[i] = Integer.parseInt(br.readLine());
			
			if(i<K) {
				int num = susiArr[i];
				
				if(kCnt.containsKey(num)) {	//이미 있다면 cnt+1
					kCnt.put(num, kCnt.get(num)+1);
				}
				else {		//없으면 그냥 추가
					kCnt.put(num, 1);
				}
			}
		}
		
		result = Math.max(kCnt.size(), result);
		
		do {
			//left 처리
			int leftNumCnt = kCnt.get(susiArr[left]);
			kCnt.remove(susiArr[left]);		//
			if(leftNumCnt>1) {		//left 숫자가 1개 이상 있을때는 숫자 올림
				kCnt.put(susiArr[left], leftNumCnt-1);
			}
			left = changeRange(left+1);
			
			//right 처리
			right = changeRange(right+1);
			if(kCnt.containsKey(susiArr[right])) {	//이미 있던 숫자는 숫자만 업데이트
				kCnt.put(susiArr[right], kCnt.get(susiArr[right])+1);
			}
			else {	//없던 숫자면 추가
				kCnt.put(susiArr[right], 1);
			}
			
			int nowKsize = kCnt.size();
			if(!kCnt.containsKey(C)) {
				nowKsize++;
			}
			result = Math.max(nowKsize, result);
		}while(left!=0);		//한 바퀴를 달 돌때까지
		
		bw.write(result + "");
		bw.close();
		br.close();
	}
	
	static int changeRange(int index) {
		if(index==N) return 0;
		return index;
	}
}
