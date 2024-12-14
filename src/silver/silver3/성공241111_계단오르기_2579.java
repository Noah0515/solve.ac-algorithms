package silver.silver3;
/*
아이디어 하나하나 다 해보기엔 너무 경우의 수가 많고 동적계획으로 처리하는게 맞을듯
queue를 이용해서 처리하자
queue에는 현재위치, 연속계단횟수, 점수를 저장하는 객체를 넣자
queue가 빌 때까지 시행하며 각 반복문 내에서 모든 경우에서 2칸 넘고, 만약 1칸만 넘었다면 1칸넘기와 2칸넘기를 둘 다 시행

1. 너무 빨라서 보진 못했지만 조금 진핸하다가 메모리초과로 실패
다이나믹 프로그래밍 접근도 맞고, 알고리즘이 틀린 것 같지도 않음.
queue에 너무 많은 데이터가 들어가서 메모리가 꽉 찬 것 같긴 한데 그럼 queue를 안쓰거나 메모리를 줄일 수 있는 방안을 구해야됨.
버전1은 백준에 기록되어있으니 새로운 짜보자

2. 성공
객체와 queue를 이용하지 않고 그냥 이차원배열을 이용한 점화식으로 바꿨다.
알고리즘의 핵심은 유지한 채 큐를 없애니 메모리 문제가 없어졌다.
 */
import java.util.Scanner;

public class 성공241111_계단오르기_2579 {
    public static void main(String[] args){
        //기본 변수
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] stair = new int[n+1];
        int[][] point = new int[n+1][3];

        stair[0] = 0;
        for(int i = 1; i <= n; i++){
            stair[i] = scan.nextInt();
        }

        point[1][1] = stair[1];
        for(int i = 0; i < n; i++){
            point[i+1][2] = Math.max(point[i+1][1], point[i][1] + stair[i+1]);
            if(i+2 <= n){
                point[i+2][1] = Math.max(point[i+2][1], point[i][1] + stair[i+2]);
                point[i+2][1] = Math.max(point[i+2][1], point[i][2] + stair[i+2]);
            }
        }

        System.out.println(Math.max(point[n][1], point[n][2]));
    }
}
