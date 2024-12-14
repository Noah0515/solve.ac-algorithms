package silver.silver2;
/*
아이디어 기존에 깔려있는 각 블럭의 평균높이를 구하고 평균높이를 기준으로 찾아감.
블럭을 제거하는것보다 까는게 2배로 효율이 좋으므로 일반적으론 까는걸 위주로
명확성을 높이기 위해 평균으로부터 까는데 걸리는 시간과 제거하는데 걸리는 시간을 구함
작은 
 */
import java.util.Scanner;

public class 마인크래프트_18111 {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), M = scan.nextInt(), B = scan.nextInt(), sum = 0, avg, height, time = Integer.MAX_VALUE, add = 0, delete = 0, cur_time;
        int ground[][] = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                ground[i][j] = scan.nextInt();
                sum += ground[i][j];
            }
        }
        avg = sum / (N * M);
        while(avg * N * M <= sum + B && (avg <= 256 || avg >= 0)){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(ground[i][j] < avg){
                        add += avg - ground[i][j];
                    } else if (ground[i][j] > avg){
                        delete += ground[i][j] - avg;
                    }
                    sum += ground[i][j];
                }
            }
            cur_time = add + delete * 2;
            if(time > cur_time){ // 현재시간이 기존보다 더 작은 경우는 드가자~
                time = cur_time;
                add = 0;
                delete = 0;
                avg++;
            } else { //현재시간이 기존보다 더 큰 경우는 뒤에서 버려~
                break;
            }
        }


        System.out.println(time + " " + --avg);
    }
}
