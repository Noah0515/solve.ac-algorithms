package silver.silver2;

import java.util.Scanner;

//이진탐색에서 기준이 되는 max와 min의 자료형을 int가 아닌 long으로 해야된다. 안그러면 범위를 넘어간다
public class 성공240103_랜선자르기_1654 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), k = scan.nextInt(), avg, count = 0;
        int[] lan = new int[n];
        long sum = 0;

        for(int i = 0; i < n ; i++){
            lan[i] = scan.nextInt();
            sum += lan[i];
        }
        avg = (int)(sum/n);

        //
        long min = 1, max = avg, cur = avg/2 + 1, length = 0;

        while(min <= max){
            //System.out.println("min = " + min + ", max = " + max + ", cur = " + cur);
            count = 0;
            for(int i = 0; i < n; i++){
                count += lan[i] / cur;
            }
            if(count >= k){
                length = cur;
                min = cur + 1;
                cur = (min + max) / 2;
            } else {
                max = cur - 1;
                cur = (min + max) / 2;
            }
        }
        System.out.println(length);
    }
}
