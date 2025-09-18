package silver.silver3;

// 56% 정도에서 시간초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 성공250918_구간합구하기4_11659 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line;
        int N, M;
        String[] input;
        try {
            line = br.readLine().split(" ");
            input = br.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        long[] sums = new long[N+1];
        sums[0] = 0;

        for(int i = 1; i <= N; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }


        for(int i = 0; i < M; i++){
            try{
                line = br.readLine().split(" ");
            } catch (IOException e){
                throw new RuntimeException();
            }
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            System.out.println(sums[y] - sums[x-1]);
        }
    }
}
