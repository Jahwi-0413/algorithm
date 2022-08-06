import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//파리퇴치
public class D2_2001 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			String[] sizes = br.readLine().split(" ");
			
			int arrSize = Integer.parseInt(sizes[0]);
			int flapperSize = Integer.parseInt(sizes[1]);
			
			int arr[][] = new int[arrSize][arrSize];

			for (int i = 0; i < arrSize; i++) {
				String[] tmp = br.readLine().split(" ");
				for (int j = 0; j < tmp.length; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			int r = calculResult(arr, flapperSize);
			bw.write("#" + (t + 1) + " " + r + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int calculResult(int[][] arr, int flapperSize) {
		int size = arr.length;

		int sum = 0;
		int max = 0;
		for (int i = 0; i <= size - flapperSize; i++)
			for (int j = 0; j <= size - flapperSize; j++) {
				for (int x = 0; x < flapperSize; x++)
					for (int y = 0; y < flapperSize; y++) {
						sum += arr[i + x][y + j];
					}

				if (sum > max)
					max = sum;
				sum = 0; // sum 초기화
			}
		return max;
	}
}