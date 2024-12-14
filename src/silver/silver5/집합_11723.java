package silver.silver5;
/*
1. 알고리즘 자체는 맞는것 같은데 28%에서 시간초과. 왜???????? 비트연산으로 바꿔보자
2. 비트연산으로 바꿔봤는데도 28%에서 시간초과.
 */
import java.util.Scanner;

public class 집합_11723 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int M  = scan.nextInt(), s = 0;
        int x,t;
        String func;

        for(int i = 0; i < M; i++){
            func = scan.next();
            if(func.equals("all")){
                s = 2000000;
                continue;
            } else if(func.equals("empty")){
                s = 0;
                continue;
            }

            x = scan.nextInt();

            if(func.equals("add")){
                s |= 1 << x;
            } else if(func.equals("remove")){
                s &= ~(1 << x);
            } else if(func.equals("check")){
                int temp = s;
                System.out.println(1 & (temp >> x));
            } else if(func.equals("toggle")){
                int temp = s;
                if((temp & (1 << x)) != 0){
                    s &= ~(1 << x);
                } else {
                    s |= 1 << x;
                }
            }
        }
    }
}
