package silver.silver4;
/*
아이디어
배열에 저장 후 sort O(nlogn)
저장된건 이진탐색 O(nlogn)

1. 11%에서 틀림 => 출력명단을 정렬안했음

2. 결과 배열을 전체 정렬하니까 null을 정렬하는 과정에서 문제가 생기는걸 발견.
    그래서 정렬의 범위를 출력의 개수만큼 하니까 성공.
*/
import java.util.Arrays;
import java.util.Scanner;

public class 성공241105_듣보잡_1764 {
    public static void main(String[] args){
        //변수선언
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int cur, min, max, x = 0, compare;
        String temp;
        String[] names = new String[n];
        String[] result = new String[Math.min(n,m)];
        //듣도 못한사람 입력
        for(int i = 0; i < n; i++){
            names[i] = scan.next();
        }

        Arrays.sort(names);
        //보도 못한 사람 입력
        for(int i = 0; i < m; i++){
            temp = scan.next();

            cur = n/2;
            min = 0;
            max = n-1;


            while(min <= max){
                compare = temp.compareTo(names[cur]);
                if(compare == 0){
                    result[x++] = temp;
                    break;
                } else if(compare < 0) {
                    max = cur - 1;
                    cur = (max + min)/2;
                } else {
                    min = cur + 1;
                    cur = (max + min)/2;
                }
            }
        }

        Arrays.sort(result, 0, x);
        System.out.println(x);
        for(int i = 0; i < x; i++){
            System.out.println(result[i]);
        }

    }
}
