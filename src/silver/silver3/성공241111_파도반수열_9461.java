package silver.silver3;
/*
아이디어 P(n) = p(n-1) + P(n-5)
이걸 초기 6개의 값을 저장하고 시작하자

1. 실패
P(n)를 저장할 변수가 잘못되었나?

2. 성공
P(n)을 int[]에서 long[]로 바꾸니까 성공함
 */
import java.util.Scanner;

public class 성공241111_파도반수열_9461 {
    public static void main(String[] args){
        //기본 변수
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m;

        //테스트케이스 개수만큼
        for(int i = 0; i < n; i++){
            //긱 테스트케이스
            m = scan.nextInt();

            //초기 5개는 할당하기
            long[] pn;
            if(m < 6){
                pn = new long[6];
            } else {
                pn = new long[m+1];
            }

            pn[1] = 1;
            pn[2] = 1;
            pn[3] = 1;
            pn[4] = 2;
            pn[5] = 2;

            //P(n) 식 적용
            for(int j = 6; j <= m; j++){
                pn[j] = pn[j-1] + pn[j-5];
            }

            System.out.println(pn[m]);
        }

    }
}
