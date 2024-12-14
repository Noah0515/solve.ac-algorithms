package silver.silver4;
/* 사이트의 주소를 key, 비밀번호를 value로 하는 haspMap을 만들어서 쓰자.
1트에 성공
 */

import java.util.HashMap;
import java.util.Scanner;

public class 성공241024_비밀번호찾기_17219 {
    public static void main(String[] args){
        //변수
        Scanner scan = new Scanner(System.in);
        int n, m;
        String site, pw;
        HashMap<String, String> pswd = new HashMap();

        //입력
        n = scan.nextInt();
        m = scan.nextInt();

        for(int i = 0; i < n; i++){
            site = scan.next();
            pw = scan.next();

            pswd.put(site, pw);
        }

        //입력되는 사이트의 비밀번호 출력
        for(int i = 0; i < m; i++){
            site = scan.next();
            System.out.println(pswd.get(site));
        }
    }
}
