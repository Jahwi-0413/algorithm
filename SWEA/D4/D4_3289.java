import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//서로소 집합
public class D4_3289 {
	static int N, M;

	static int[] parents;

	static void make() { // 크기가 1인 서로소 집합 생성
		parents = new int[N + 1];

		for (int i = 1; i < N + 1; i++) { // 모든 노드가 자신을 부모로하는 (대표자) 집합으로 만듦
			parents[i] = i;
		}
	}

	static int find(int a) { // a의 대표자 찾기
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]); // 우리의 대표자를 나의 부모로 -> path compression
	}

	static boolean union(int a, int b) { // true -> union 성공
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false; // 이미 같은 집합

		parents[bRoot] = aRoot;

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			make();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (cmd == 1) {
					if (find(a) == find(b)) { // true면 이미 같은 집합
						sb.append(1);
						continue;
					}
					sb.append(0);
				}
				else {
					union(a,b);
				}
			}
			StringBuilder res = new StringBuilder();
			
			res.append("#").append(t).append(" ").append(sb.toString()).append("\n");
			bw.write(res.toString());
		}
		bw.flush();
		bw.close();
		br.close();
	}
}