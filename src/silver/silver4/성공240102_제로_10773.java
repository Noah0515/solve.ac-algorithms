package silver.silver4;

import java.util.Scanner;
import java.util.Stack;

public class 성공240102_제로_10773 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        int n, sum = 0;
        Stack<Integer> money = new Stack<>();

        for(int i = 0; i < K; i++){
            n = scan.nextInt();
            if(n != 0){
                money.push(n);
            } else {
                money.pop();
            }
        }

        while(!money.isEmpty()){
            sum += money.pop();
        }

        System.out.println(sum);
    }
}
