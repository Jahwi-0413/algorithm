package ws0819;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//숨바꼭질
public class BJ_1697 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		bw.write(bfs(new boolean[100001]) + "");
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs(boolean[] visited) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(N);
		visited[N] = true;
		int result = 0;
		int size = que.size();
		if(N==M)return 0;
		
		while(true) {
			result++;
			size = que.size();
			
			for(int i=0; i<size; i++) {
				int value = que.poll();
				visited[value] = true;

				if(value-1==M || value+1==M || value*2==M || value==M)
					return result;
				
				if(value-1 >=0 && !visited[value-1])
					que.offer(value-1);
				if(value+1<=100000  && !visited[value+1])
					que.offer(value+1);
				if(value*2<=100000 && !visited[value*2])
					que.offer(value*2);
			}
		}
	}
}
/*
100 0 # 100
6 16 # 3
8 20 # 3
15964 89498 # 4781
3 43 # 6
4 27 # 5
5 35 # 5
6 43 # 5
7 43 # 6
100 1 # 99
10 19 # 2
5 19 # 3
1 20 # 5
100000 100000 # 0
0 100000 # 22
100000 0 # 100000
0 1 # 1
3482 45592 # 637
2 4 # 1
9 5 # 4
5 5 # 0
5 17 # 4
*/