package silver.silver3;

import java.util.Scanner;

//소수찾기는 에라토스테네스의 체 알고리즘을 쓰자
public class 성공240103_소수구하기_1929 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt(), n = scan.nextInt();
        boolean[] prime = new boolean[n + 1];

        for(int i = 2; i <= n; i++){
            prime[i] = true;
        }

        for(int i = 2; i*i <= n; i++){
            if(prime[i]){
                for(int j = i * i; j <= n; j += i){
                    prime[j] = false;
                }
            }
        }

        for(int i = Math.max(2,m); i <= n; i++){
            if(prime[i]){
                System.out.println(i);
            }
        }
    }
}
