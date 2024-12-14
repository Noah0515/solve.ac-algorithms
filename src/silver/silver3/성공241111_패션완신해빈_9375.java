package silver.silver3;
/*
아이디어 COmbination을 사용.
의상종류가 1이면 nC1, 여러개면 각 의상종류별로 nC1 + 1 을 곱하고 저렇게 하면 알몸인경우 1이 발생하므로 1을 빼준다.
데이터를 보면 value/key 쌍이고, 우리는 의상 종류당 개수만 신경쓰므로 각 의상개수별루 count하자.

1트에 성공
 */
import java.util.HashMap;
import java.util.Scanner;

public class 성공241111_패션완신해빈_9375 {
    public static void main(String[] args){
        //기본 변수
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m;
        String temp;
        int strIndex;
        int result;

        //각 테스트케이스별 for문
        for(int i = 0; i < n; i++){
            m = scan.nextInt();
            scan.nextLine();

            result = 1;
            HashMap<String, Integer> count = new HashMap<>();
            //해당 테스트케이스에서의 for문
            for(int j = 0; j < m; j++){
                temp = scan.nextLine();
                strIndex = temp.indexOf(" ");
                temp = temp.substring(strIndex + 1);

                if(count.containsKey(temp) == true){
                    count.put(temp, count.get(temp) + 1);
                } else {
                    count.put(temp, 1);
                }
            }
            for(int t : count.values()){
                result *= ++t;
            }
            result--;
            System.out.println(result);
        }
    }
}
