package silver.silver3;
/*
아이디어 몇개의 예를 가지고 패턴을 파악해보자
0: 1, 0
1: 0, 1
2: 1, 1
3: 1, 2
4: 2, 3
5: 3, 5
5: 5, 8
0, 1은 특수 케이스이고, 그 외는 0이 호출되는 경우와 1이 호출되는 경우가 또 하나의 피보나치 함수

1. 실패. n = 2인경우에 배열의 크기를 할당을 잘못함

2. 성공. n = 2일때 배열의 크기를 2에서 3으로 바꾸고 성공
 */
import java.util.Scanner;

public class 성공241121_피보나치함수_1003 {
    public static void find(int n){
        int[][] fibo;
        //입력 숫자의 크기에 따라 다른 크기 할당
        if(n > 2){
            fibo = new int[n+1][2];
        } else {
            fibo = new int[3][2];
        }
        //초기값 초기화
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        //계산
        for(int i = 2; i <= n; i++){
            fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
            fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
        }

        System.out.println(fibo[n][0] + " " + fibo[n][1]);
    }
    public static void main(String[] args){
        //변수
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int num;

        //테스트케이스 개수만큼 반복
        for(int i = 0; i < n; i++){
            num = scan.nextInt();
            find(num);
        }
    }
}
