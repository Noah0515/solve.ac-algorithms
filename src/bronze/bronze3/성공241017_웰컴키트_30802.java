package bronze.bronze3;

import java.util.Scanner;

public class 성공241017_웰컴키트_30802 {
    public static void main(String args[]) {
        //변수
        Scanner scan = new Scanner(System.in);
        int[] size = new int[6];
        int N, P, T;
        int result = 0;

        //데이터입력
        N = scan.nextInt();

        for(int i = 0; i < 6; i++){
            size[i] = scan.nextInt();
        }

        T = scan.nextInt();
        P = scan.nextInt();

        //티셔츠 계산
        for(int i = 0; i < 6; i++) {
            result += size[i] / T;
            if(size[i] % T != 0){
                result++;
            }
        }
        System.out.println(result);
        //펜 계산
        System.out.println(N / P + " " + N % P);
    }
}
