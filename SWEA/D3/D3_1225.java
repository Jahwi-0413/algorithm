import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//암호생성기
public class D3_1225 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	         
	        for(int t=0; t<10; t++) {
	            Integer.parseInt(br.readLine());
	             
	            Queue<Integer> queue = new LinkedList<>();
	            String[] tmp = br.readLine().split(" ");
	             
	            for(int i=0; i<tmp.length; i++) {
	            	int n = Integer.parseInt(tmp[i]);
	            	queue.add(n);
	            }
	            
	            int i=1;
	            while(true) {		//사이클
	            	if(i==6)
	            		i=1;
	            	int n = queue.remove() - i;
	            	if(n<=0) {
	            		queue.add(0);
	            		break;
	            	}
	            	queue.add(n);
	            	i++;
	            }
	            
	            bw.write("#" + (t+1) + " ");
	            while(!queue.isEmpty()) {
	            	bw.write(queue.remove() + " ");
	            }
	            bw.write("\n");
	        }
	        bw.flush();
	        bw.close();
	}
}
