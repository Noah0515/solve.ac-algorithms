package silver.silver3;
/*
아이디어 1개의 제곱수, 2개의 제곱수, 3개의 제곱수, 4개의 제곱수 순서로 찾아야될 것 같음.
반복문 범위는 루트n보다 같거나 큰 가장 작은 자연수까지.
1개의 제곱수에서 제곱수들을 저장함. O(logn)
2개의 제곱수에선 제곱수들을 양 끝부터 가운데로 좁히면서. 2개씩 제곱해서 가능한 경우의 수도 저장함.
- 근데 이러면 3개, 4개인 경우 의미없는 데이터이므로 그냥 모든 경우의수를 하자O(n^2)
3개의 제곱수에선 1과 2에서 구한 제곱수들로 2에서처럼 해보기 O(n^2)
4개의 제곱수인 경우는 1,2,3이 다 아니였을 경우 수학적으로 증명되었음.

1. 4%에서 틀림. 뭐가 문제인지 이해가 안됨

2. 성공
제곱수가 3개인경우에 문제가 있었다. 기존의 코드에선 two가 정렬되어있지 않았다. 근데 제곱수가 세개인 경우 one+two면 break를 해벼렸다.
그러면 two의 뒷부분이 남아있는데 계산을 못해서 넘어가버린다.
그래서 제곱수가 세개인 경우를 할 때 two를 정렬하고 시작하니 성공했다.r
 */
import java.util.Arrays;
import java.util.Scanner;

public class 성공241112_FourSquires_17626 {
    public static void main(String[] args){
        //기본 변수
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sqrt = (int)Math.sqrt(n),range1 = 0, range2 = 0, range3 = 0;
        int[] one = new int[sqrt], two, three;
        int temp = 0;

        //1개의 제곱수
        for(int i = 1; i <= sqrt; i++){
            one[range1] = i*i;

            if(one[range1] == n){
                System.out.println("1");
                return;
            }
            range1++;
        }

        //2개의 제곱수
        two = new int[range1*range1];

        for(int i = 0; i < range1; i++){
            for(int j = i; j < range1; j++){
                temp = one[i] + one[j];

                if(temp > n){
                    break;
                } else if(temp < n){
                    two[range2++] = temp;
                } else {
                    System.out.println("2");
                    return;
                }
            }
        }

        //3개의 제곱수
        three = new int[range1*range2];
        Arrays.sort(two, 0 , range2); // two를 정렬해야 제대로 작동함
        for(int i = 0; i < range1; i++){
            for(int j = 0; j < range2; j++){
                temp = one[i] + two[j];

                if(temp > n){
                    break;
                } else if(temp < n){
                    three[range3++] = temp;
                } else {
                    System.out.println("3");
                    return;
                }
            }
        }

        //4개의 제곱수
        System.out.println("4");

    }
}
