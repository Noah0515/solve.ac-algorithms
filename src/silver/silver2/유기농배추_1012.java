package silver.silver2;
/*
아이디어 일단 배추밭은 int이차원배열을 이용하자. 음 다이나미프로그래밍이 맞는 것 같음
초기에 배추가 없으면 0, 있으면 1임.
배추가 들어있는 지점을 queue로 저장하자.
배추가 들어있는 지점을 하나씩 빼면서 시작.
탐색은 bfs처럼 queue를 이요해서 하자. 만약 배추가 있다면 값을 2로 바꿔서 이미 지나갔다는것을 표시
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 유기농배추_1012 {
    public static void main(String[] args){
        //기본 변수
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int m, n, k, x, y;

        //테스트케이스
        for(int i = 0; i < t; i++){
            //각 테스트케이스 별 변수들
            m = scan.nextInt();
            n = scan.nextInt();
            k = scan.nextInt();
            int[][] farm = new int[n][m];
            int[] cur, temp;
            int count = 0;
            Queue<int[]> warm = new LinkedList<>();
            Queue<int[]> filled = new LinkedList<>();

            //배추 입력
            for(int j = 0; j < k; j++){
                x = scan.nextInt();
                y = scan.nextInt();
                farm[y][x] = 1;
                filled.add(new int[]{y, x});
            }

            //입력받은 각 배추들로부터
            while(!filled.isEmpty()){
                temp = filled.poll();

                //아직 탑색하지 않은 배추라면
                if(farm[temp[0]][temp[1]] == 1){
                    warm.add(temp);
                    farm[temp[0]][temp[1]] = 2;
                    //해당 배추로부터 주위를 탑핵
                    while(!warm.isEmpty()){
                        cur = warm.poll();
                        x = cur[1];
                        y = cur[0];

                        if(x > 0){
                            if(farm[y][x-1] == 1){
                                farm[y][x-1] = 2;
                                warm.add(new int[]{y,x-1});
                            }
                        }
                        if(x < n-1){
                            if(farm[y][x+1] == 1){
                                farm[y][x+1] = 2;
                                warm.add(new int[]{y,x+1});
                            }
                        }
                        if(y > 0){
                            if(farm[y-1][x] == 1){
                                farm[y-1][x] = 2;
                                warm.add(new int[]{y-1,x});
                            }
                        }
                        if(y < n-1){
                            if(farm[y+1][x] == 1){
                                farm[y+1][x] = 2;
                                warm.add(new int[]{y+1,x});
                            }
                        }

                    }
                    count++;
                }
            }
            System.out.println();
            //for(int a =
            System.out.println(count);

        }
    }
}
