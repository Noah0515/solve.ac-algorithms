package bronze.bronze1;

import java.util.Scanner;

public class FizzBuzz_28702 {
    public static void main(String args[]){
        //변수
        Scanner scan = new Scanner(System.in);

        String[] s = new String[3];
        int[] n = new int[3];
        int temp = 1;

        //입력
        for(int i = 0; i < 3; i++){
            s[i] = scan.nextLine();
        }

        //계산
        int i;
        for(i = 3; i >= 1; i--){
            try{
                temp = Integer.parseInt(s[3-i]);
                break;
            } catch (Exception e){

            }
        }

        temp += i;

        if(temp % 3 != 0){
            if(temp % 5 != 0){
                System.out.println(temp);
            }else{
                System.out.println("Buzz");
            }
        }else{
            if(temp %5 != 0){
                System.out.println("Fizz");
            } else {
                System.out.println("FizzBuzz");
            }
        }
    }
}
