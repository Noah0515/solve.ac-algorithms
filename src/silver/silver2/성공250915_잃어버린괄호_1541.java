package silver.silver2;

import java.util.Arrays;
import java.util.Scanner;

public class 성공250915_잃어버린괄호_1541 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String problem = scan.nextLine();

        int last = 0;
        int length = problem.length();
        int[] nums = new int[length];
        int idx_n = 0;
        int[] operators = new int[length];
        int idx_o = 0;


        for(int i = 0; i < length; i++){
            if (problem.charAt(i) == '+' || problem.charAt(i) == '-'){
                if (problem.charAt(i) == '+'){
                    operators[idx_o++] = 1; // 덧셈이면 1
                } else {
                    operators[idx_o++] = 0; // 뺄셈이면 0
                }

                nums[idx_n++] = Integer.parseInt(problem.substring(last, i));
                //System.out.println(nums[idx_n-1]);
                last = i+1;

            }
        }

        //마지막 숫자
        nums[idx_n++] = Integer.parseInt(problem.substring(last, length));


        int result = calculate(Arrays.copyOfRange(nums,0,idx_n), Arrays.copyOfRange(operators,0,idx_o));

        System.out.println(result);
    }

    // 값이 최소가 되려면 빼기가 커져야됨.
    // 덧셈은 묶고 뺄셈은 그대로 가자.
    public static int calculate(int[] nums, int[] operators) {
        int sum = 0;
        int o_len = operators.length;
        boolean sub = false;

        sum += nums[0];

        for(int i = 0; i < o_len; i++){
            if(sub){
                sum -= nums[i+1];
            } else {
                if (operators[i] == 1){
                    sum += nums[i+1];
                }else if(operators[i] == 0){
                    sub = true;
                    sum -= nums[i+1];
                }
            }
        }

        return sum;
    }
}
