package silver.silver4;
/*아이디어: 배열을 이용해서 시간을 저장. 이걸 정렬. 정렬된 데이터가지고 반복문으로 a[i]*(i+1)하면 될듯
1트에 성공. 대신 Arrays.sort()를 씀.
 */

import java.util.Arrays;
import java.util.Scanner;

public class 성공241024_ATM_11399 {
    public static void main(String args[]){
        //변수
        Scanner scan = new Scanner(System.in);
        int n, result = 0;
        int[] time;

        //입력
        n = scan.nextInt();
        time = new int[n];

        for(int i = 0; i < n; i++){
            time[i] = scan.nextInt();
        }

        //정렬
        Arrays.sort(time);

        //시간 갱신
        for(int i = 0; i < n; i++){
            result += time[i] * (n-i);
        }

        //출력
        System.out.println(result);
    }
}
