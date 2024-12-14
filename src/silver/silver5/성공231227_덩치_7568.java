package silver.silver5;

import java.util.Scanner;

public class 성공231227_덩치_7568 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[][] data = new int[size][4];


        for(int i = 0; i < size; i++){
            data[i][0] = scan.nextInt();
            data[i][1] = scan.nextInt();
            data[i][2] = 1;
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i != j) {
                    if(data[i][0] < data[j][0] && data[i][1] < data[j][1])
                        data[i][2]++;
                }
            }
        }

        for(int i = 0; i < size; i++){
            System.out.print(data[i][2] + " ");
        }
    }
}
