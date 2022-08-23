import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Edge implements Comparable<Edge>{
    int from, to;
    long weight;
 
    public Edge(int from, int to, long weight) {
        super();
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
 
    @Override
    public int compareTo(Edge o) {
        return (int) (this.weight - o.weight);
    }
}
 
//최소 스패닝 트리
public class D4_3124 {
    static int V,E;
    static Edge[] edgeList;
    static int[] parents;
     
    static void make() {
        parents = new int[V+1];
         
        for(int i=1; i<V+1; i++) //최초에는 모든 노드가 자기 자신을 가리키는 트리
            parents[i] = i;
    }
     
    static int find(int a) {
        if(parents[a]==a) return a; //자기 자신이 자신의 대표자인 경우
         
        return parents[a] = find(parents[a]);   //만약 다른 사람이 대표자인 경우 a의 대표자를 업데이트
    }
     
    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
         
        if(aRoot==bRoot) return false;  //이미 a와 b가 같은 트리에 있음
         
        parents[bRoot] = aRoot;     //b를 a의 대표자와 연결 -> 트리를 합침
        return true;
    }
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int tc = Integer.parseInt(br.readLine());
         
        for(int t=1; t<=tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
             
            edgeList = new Edge[E]; //1번째 index부터 시작
             
            for(int i=0; i<E; i++) { //정점 정보 입력
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                 
                edgeList[i] = new Edge(from, to, weight);
            }
             
            make();
            Arrays.sort(edgeList);
             
            long result = 0;
            int count = 0;
             
            for(Edge edge : edgeList) {
                if(union(edge.from, edge.to)) { //트리 연결 가능
                    result += edge.weight;
                    if(++count==V-1) break;
                }
            }
             
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(result).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}