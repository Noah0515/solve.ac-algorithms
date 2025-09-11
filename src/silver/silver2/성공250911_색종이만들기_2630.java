package silver.silver2;

import java.util.Arrays;
import java.util.Scanner;

public class 성공250911_색종이만들기_2630 {
    public static void main(String[] args){
        int N;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        int total = 0;
        int[][] paper = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                paper[i][j] = scan.nextInt();
            }
        }

        int[] result = cut(paper);

        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    // 종이를 자르는 함수.
    public static int[] cut(int[][] part){
        int cur_N = part.length;

        int[] total = new int[2];
        total[0] = 0;
        total[1] = 0;

        int cur = isSame(part);
        if(cur != -1){
            total[cur] += 1;
        } else {
            int[] result_1 =  cut(slice(part, cur_N, 0, cur_N/2, 0, cur_N/2));
            int[] result_2 =  cut(slice(part, cur_N, 0, cur_N/2, cur_N/2, cur_N));
            int[] result_3 =  cut(slice(part, cur_N, cur_N/2, cur_N, 0, cur_N/2));
            int[] result_4 =  cut(slice(part, cur_N, cur_N/2, cur_N, cur_N/2, cur_N));

            total[0] += result_1[0] + result_2[0] + result_3[0] + result_4[0];
            total[1] += result_1[1] + result_2[1] + result_3[1] + result_4[1];
        }

        return total;
    }

    // 종이 부분이 한 색으로 이루어져있는지
    // [0][0]와 다른 색이 나오면 바로 종료
    public static int isSame(int[][] part){
        int width = part[0].length;
        int height = part.length;

        int first = part[0][0];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if (part[i][j] != first){
                    return -1;
                }
            }
        }

        return first;
    }

    // 배열을 슬라이싱하는거.
    public static int[][] slice(int[][] array, int N, int start_x, int end_x, int start_y, int end_y){
        int[][] sliced = new int[N/2][];
        int k = 0;

        for(int i = start_y; i < end_y; i++){
            int[] temp = Arrays.copyOfRange(array[i], start_x, end_x);
            sliced[k++] = temp;
        }

        return sliced;
    }
}
