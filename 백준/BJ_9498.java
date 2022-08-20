package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//시험성적
public class BJ_9498 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		
		if(90<=input && input<=100)
			bw.write("A");
		else if(80<=input && input<=89)
			bw.write("B");
		else if(70<=input && input<=79)
			bw.write("C");
		else if(60<=input&& input<=69)
			bw.write("D");
		else
			bw.write("F");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
