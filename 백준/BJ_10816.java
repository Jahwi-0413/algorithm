import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//숫자카드 2
public class BJ_10816 {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> cards = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {							//카드를 입력받을때 cnt 값을 저장해둠
			int value = Integer.parseInt(st.nextToken());
			if(cards.containsKey(value)) {
				int cnt = cards.get(value);
				cards.remove(value);
				cards.put(value,  cnt+1);
			}
			else {
				cards.put(value, 1);
			}
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {			//M배열을 받을때 각 값에 해당하는 cnt 값을 불러와서 저장
			int key = Integer.parseInt(st.nextToken());
			if(cards.containsKey(key)) {
				bw.write(cards.get(key) + " ");
				continue;
			}
			bw.write(0 + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
