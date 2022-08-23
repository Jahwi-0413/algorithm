import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//ABCDE
public class BJ_13023 {
	static int N, M;
	static List<List<Integer>> friends;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		friends = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			friends.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			friends.get(from).add(to);
			friends.get(to).add(from);
		}
		
		for(int i=0; i<N; i++) {	//입력받은 친구들을 정렬
			Collections.sort(friends.get(i));
			boolean[] isFriend = new boolean[N];
			isFriend[i] = true;
			if(dfs(i, isFriend, 1)) {
				result = 1;
				break;
			}
		}
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean dfs(int from, boolean[] visited, int cnt) {
		List<Integer> tmp = friends.get(from);
		if(cnt==5) {		//친구를 다섯명 만들 수 있음
			return true;
		}
		
		for(int i=0, size=tmp.size(); i<size; i++) {
			int to = tmp.get(i);
			if(visited[to]) continue;
			visited[to] = true;
			boolean check = dfs(to, visited, cnt+1);
			if(check) return true;	//이미 친구를 찾았다면 더 탐색할 필요 없음
			visited[to] = false;
		}
		return false;
	}
}