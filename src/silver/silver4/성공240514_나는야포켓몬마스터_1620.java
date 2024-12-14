package silver.silver4;
/*
1. 포켓몬 도감을 배열로 사용한 경우 알고리즘은 맞지만 8%에서 시간초과 발생. 배열보다 빠른 알고리즘을 고려하자.
2. 배열과 해시를 같이 사용함. 번호로 이름을 찾을때는 배열, 이름으로 번호를 찾을때는 해시. 메모리는 많이 쓰지만 이게 빠름
 */
import java.util.HashMap;
import java.util.Scanner;

public class 성공240514_나는야포켓몬마스터_1620 {
    public static void main(String[] args){
        //변수 선언
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), M = scan.nextInt(), temp_n;
        String temp_s;
        String[] pokectmons = new String[N];
        HashMap<String, Integer> P = new HashMap<>();

        //포켓몬 도감 만들기
        for(int i = 0; i < N; i++){
            pokectmons[i] = scan.next();
            P.put(pokectmons[i],i+1);
        }

        //입력에 따라 다른 출력
        for(int i = 0; i < M; i++){
            temp_s = scan.next();
            try{
                temp_n = Integer.parseInt(temp_s);
                System.out.println(pokectmons[temp_n-1]);
            } catch(Exception e){//숫자가 아닌경우는 예외처리로 받아서 해결
                System.out.println(P.get(temp_s));
            }
        }
    }
}
