package algorithm.assignment3;

import java.util.Scanner;

public class CutDia {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] value = new int[n+1];
        int result;

        for(int i = 1; i <= n; i++){
            value[i] = scan.nextInt();
        }

        result = maxSell(n, value);
        System.out.println(result);
    }

    public static int maxSell(int mass, int[] value){
        int maxVal;
        int[] max = new int[mass + 1];
        max[0] = 0;

        for(int i = 1; i <= mass; i++){
            maxVal = 0;
            for(int j = 1; j <= i; j++){
                maxVal = Math.max(maxVal, value[j] + max[i - j]);
            }
            max[i] = maxVal;
        }

        return max[mass];
    }
}
