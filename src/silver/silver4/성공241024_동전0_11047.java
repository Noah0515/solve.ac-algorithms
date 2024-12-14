package silver.silver4;
/* 아이디어: 동전의 가치는 배열의 저장. 반복문과 나누기 연산을 이용하여 최소동전의 개수를 찾자.
1트에 성공
 */
import java.util.Scanner;

public class 성공241024_동전0_11047 {
    public static void main(String[] args){
        //변수선언
        Scanner scan = new Scanner(System.in);
        int n, k, result = 0, temp;
        int[] coin;

        //입력
        n = scan.nextInt();
        k = scan.nextInt();
        coin = new int[n];

        for(int i = n-1; i >= 0 ; i--){
            coin[i] = scan.nextInt();
        }

        //동전개수 계산
        for(int i = 0; i < n; i++){
            temp = k/coin[i];
            if(temp > 0){
                k -= temp*coin[i];
                result += temp;
                //System.out.println("현재 동전: " + coin[i] + ", 현재 동전개수: " + result);
            }
        }

        System.out.println(result);
    }

}
