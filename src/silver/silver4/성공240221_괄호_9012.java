package silver.silver4;

import java.util.Scanner;
import java.util.Stack;

public class 성공240221_괄호_9012 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(), length;
        boolean error;
        Stack<Boolean> check = new Stack<>();
        String vps;


        for(int i = 0; i < T; i++){
            error = false;
            check.clear();
            vps = scan.next();
            length = vps.length();
            for(int j = 0; j < length; j++){
                try{
                    if(vps.charAt(j) == '('){
                        check.push(true);
                    } else {
                        check.pop();
                    }
                } catch(Exception e) {
                    error = true;
                    break;
                }
            }
            if(error){
                System.out.println("NO");
            } else {
                if(check.isEmpty()){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
