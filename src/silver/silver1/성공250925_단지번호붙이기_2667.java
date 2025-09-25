package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class 성공250925_단지번호붙이기_2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] apt = new int[N][N];
        String s;
        LinkedList<Integer> list = new LinkedList<>();
        int num = 0;

        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < N; j++) {
                apt[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //System.out.println("x: " + j + ", y: " + i);
                int result = search(apt, j, i, N);
                if (result > 0) {
                   // System.out.println(result);
                    list.add(result);
                    num++;
                }
            }
        }

        Collections.sort(list);

        System.out.println(num);
        for (int i : list) {
            System.out.println(i);
        }


    }

    public static int search(int[][] apt, int x, int y, int N) {
        if (x < 0 || y < 0 || x >= N  || y >= N || apt[y][x] != 1) {
            //System.out.println("패스 x: " + x + ", y: " + y);
            return 0;
        }
        //System.out.println("집이당~ x: " + x + ", y: " + y);
        apt[y][x] = 2;
        int sum = 1;

        sum += search(apt, x + 1, y, N);
        sum += search(apt, x - 1, y, N);
        sum += search(apt, x, y + 1, N);
        sum += search(apt, x, y - 1, N);

        return sum;
    }
}
