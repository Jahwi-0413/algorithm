import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Z
public class BJ_17135 {
	static int N, resultR, resultC;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");

		N = Integer.parseInt(st.nextToken());
		resultR = Integer.parseInt(st.nextToken());
		resultC = Integer.parseInt(st.nextToken());
		int mapSize = (int)Math.pow(2, N);
		
		search(0, 0, mapSize);
	}
	public static void search(int r, int c, int size) {
		if(size==1) {
			result++;
			if(r==resultR && c==resultC) {
				System.out.print(result-1);
			}
			return;
		}
		
		int half = size/2;
		
		if(r <= resultR && resultR<r+half && c<=resultC && resultC <c+half) {
			search(r, c, half);
		}
		if(r <= resultR && resultR<r+half && c+half <= resultC && resultC < c+size) {
			result+= (int)(size*size*(0.25));
			search(r, c+half, half);
		}
			
		if(r+half <= resultR && resultR < r+size && c<=resultC && resultC <c+half) {
			result+= (int)(size*size*(0.5));
			search(r+half, c, half);
		}
		if(r+half <= resultR && resultR < r+size && c+half<=resultC && resultC <c+size) {
			result+= (int)(size*size*(0.75));
			search(r+half, c+half, half);
		}
	}
}
