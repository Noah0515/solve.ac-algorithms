package silver.silver5;

//시간초과
//arrays.sort에 Comparator에 조건을 추가해서 성공!!!!!!!

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 성공240311_좌표정렬하기_11650 {
    public static void main(String[] args){
        //변수 선언
        Scanner scan = new Scanner(System.in);//스캐너
        int N = scan.nextInt();//입력되는 좌표의 개수
        int[][] vector = new int[N][2];//좌표들을 저장하는 2차원배열

        //N개만큼의 좌표를 읽어서 vector에 저장
        for(int i = 0; i < N; i++){
            vector[i][0] = scan.nextInt();
            vector[i][1] = scan.nextInt();
        }

        //vector에 저장된 좌표를 정렬
        Arrays.sort(vector, new Comparator<int[]>(){//Comparator를 사용해 정렬 조건 변경
            public int compare(int[] v1, int[] v2){
                if(v1[0] == v2[0]){//x좌표가 같은 경우 y좌표가 큰게 뒤로 가게
                    return v1[1] - v2[1];
                } else {//x좌표가 다른 경우 x좌표가 큰게 뒤로 가게
                    return v1[0] - v2[0];
                }
            }
        });

        //정렬된 vector를 순차적으로 출력
        for(int i = 0; i < N; i++){
            System.out.println(vector[i][0] + " " + vector[i][1]);
        }
    }
}
