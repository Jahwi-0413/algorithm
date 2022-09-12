import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//스타트링크
public class BJ_5014 {
	static int F,S,G,U,D,res;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F+1];
		
		boolean result = bfs();
		if(result)
			bw.write(res + "");
		else
			bw.write("use the stairs");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		visited[S] = true;
		
		if(S==G) return true;
		
		while(!q.isEmpty()) {
			res++;
			for(int i=0,size=q.size(); i<size; i++) {
				int now = q.poll();
				
				int nowUp = now + U;
				int nowDown = now - D;
				
				if(nowUp==G || nowDown==G)
					return true;
				
				if(nowUp <= F && !visited[nowUp]) {
					q.add(nowUp);
					visited[nowUp] = true;					
				} 
				if(nowDown >= 1 && !visited[nowDown]) {
					q.add(nowDown);
					visited[nowDown] = true;
				}
			}
			
		}//end of while
		return false;
	}
}
