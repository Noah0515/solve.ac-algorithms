package algorithm.assignment3;

import java.util.Scanner;

public class CutDia2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int w = scan.nextInt();
        int[] price = new int[w + 1];
        int[] cost = new int[w + 1];

        for(int i = 1; i <= w; i++){
            price[i] = scan.nextInt();
        }

        for(int i = 1; i < w; i++){
            cost[i] = scan.nextInt();
        }

        int result = maxSell(w, price, cost);
        System.out.println(result);

        result = maxSell2(w, price, cost);
        System.out.println(result);
    }

    public static int maxSell(int w, int[] price, int[] cost){
        int max = price[w];
        int cur_p;
        for(int i = 1; i < w; i++){
            cur_p = price[i] + maxSell(w-i, price, cost) - cost[i];

            max = Math.max(max, cur_p);
        }

        return max;
    }

    public static int maxSell2(int w, int[] price, int[] cost){
        int[] m = new int[w + 1];
        int cur_p;

        for(int i = 1; i <= w; i++){
            m[i] = price[i];

            for(int j = 1; j < i; j++){
                cur_p = price[j] + m[i - j] - cost[j];

                m[i] = Math.max(m[i], cur_p);
            }
        }
        return m[w];
    }
}
