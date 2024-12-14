package silver.silver3;
/*
아이디어 타일이 1x2니까 세워서 2x1을 채우거나, 눕혀서 1x2를 두개 놓거나 둘 중 하나임.
점화식을 세워서 다아나믹 프로그래밍 방식을 사용하자

1. 1%에서 틀림. int 범위가 너무 작아서 그럴지도

2. long으로 바꿔도 틀림

3. 다시 int로 바꾸고 매 계산시 10007을 나눠줬는데 또 1%에서 틀림

4. 3에서 마지막 출력에도 10007로 나눠주는걸 넣어주니까 됨
 */
import java.util.Scanner;

public class 성공241111_2xn타일링_11726 {
    public static void main(String[] args){
        //기본 변수
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a1 = new int[n+1]; //끝이 2x1이 세워져있는경우
        int[] a2 = new int[n+1]; //끝이 1x2두개가 누워있는경우

        //
        a1[1] = 1;
        if(n > 1) {
            a2[2] = 1;
        }

        for(int i = 1; i < n ; i++){
            a1[i+1] += a1[i] + a2[i];
            a1[i+1] %= 10007;
            if(i+2 <= n) {
                a2[i + 2] += a2[i] + a1[i];
                a2[i + 2] %= 10007;
            }
        }

        System.out.println((a1[n] + a2[n])%10007);
    }
}
