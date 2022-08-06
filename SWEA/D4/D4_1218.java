import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
 
class Pair{
    char left;
    char right = ' ';
     
    public Pair(char left) {
        super();
        this.left = left;
        switch(left) {
        case '(': right = ')'; break;
        case '{': right = '}'; break;
        case '<': right = '>'; break;
        case '[': right = ']'; break;
        }
    }
}
//괄호 짝짓기
public class D4_1218 {
    public static void main(String[] args) throws NumberFormatException, IOException{
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        for(int t=0; t<10; t++) {
            Integer.parseInt(br.readLine());
             
            Stack<Pair> stack = new Stack<>();
            char[] tmp = br.readLine().toCharArray();
             
            for(int i=0; i<tmp.length; i++) {
                if(tmp[i]=='(' || tmp[i]=='<' || tmp[i]=='{' || tmp[i]=='[') {   //({<[이 나오면 push
                    stack.push(new Pair(tmp[i]));
                }
                else {
                    char check = stack.peek().right;
                    if(!stack.isEmpty() &&check==tmp[i]) {                  // )}>]가 나오면 pair 체크
                        stack.pop();
                    }
                    else {      //짝이 아니면 실패
                        break;
                    }
                }
            }
            bw.write("#" + (t+1) + " ");
            if(!stack.isEmpty()) {
                bw.write("0\n");
            }
            else
                bw.write("1\n");
        }
        bw.flush();
        bw.close();
    }
}