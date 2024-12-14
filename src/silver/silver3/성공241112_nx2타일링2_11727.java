package silver.silver3;
/*
아이디어 끝이 2x2인 경우, 2x1인경우, 1x2를 두개 쌓은 경우 세개임
A(n) = A(n-1) + A(n-2)*2;
A(0) = 0, A(1) = 1, A(2) = 3
 */
import java.util.Scanner;

public class 성공241112_nx2타일링2_11727 {
    public static void main(String[] args){
        //기본변수
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a;
        if(n < 2){
            a = new int[3];
        } else {
            a = new int[n + 1];
        }

        //기본값 초기화
        a[0] = 0;
        a[1] = 1;
        a[2] = 3;

        //점화식으로 구하기
        for(int i = 3; i <= n; i++){
            a[i] = a[i-1] + 2*a[i-2];
            a[i] %= 10007;
        }

        System.out.println(a[n]);
    }
}
