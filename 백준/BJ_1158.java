package ws0808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1158 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        Queue<Integer> que = new LinkedList<>();

        String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

        for(int i =1;i<=N;i++) {
            que.add(i);
        }

        bw.write("<");
        while (que.size()>1) {
        	//k가 아닌 것들은 다시 que에 삽입
            for(int i =0; i<K-1;i++) {
                int value = que.poll();
                que.offer(value);
            }
            bw.write(que.poll() + ", ");
        }
        bw.write(que.poll() + ">");
        bw.flush();
        bw.close();
    }
}
