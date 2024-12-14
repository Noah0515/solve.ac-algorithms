package silver.silver4;
/*
    1. 34%에서 시간초과가 뜸. 계산하는 과정 자체는 문제가 없는것으로 보이지만 시간을 줄일 방법을 생각해야됨.
     정렬쪽이 시간을 가장 많이 잡아먹는데 라이브러리에 있는 함수를 사용해서 배열의 방법으로는 가장 빠름. 다른 자료구조를 활용할 생각을 해봐야할듯.
     점수는 1~30으로 고정이므로 크기가 30인 정수 배열에 받은 점수들의 개수를 저장해서 계산하는 방식을 채택해보자.
    2. 점수들을 저장하는 방식을 각 점수들을 각 인덱스에 집어넣는 방식에서 점수에 해당하는 인덱스의 개수로 점수를 저장하는 방식으로 바꿔보았지만
     여전히 34%에서 시간초과가 뜬다. 입력도 바꿔야 되나?
 */
;
import java.util.Scanner;

public class solvedac_18110 {
    public static void main(String args[]){
        //변수 선언
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), sum = 0, score;
        int[] scores = new int[31];

        //절사평균 구하기
        int range = (int)Math.round(N * 0.15);

        //N이 0인경우 판단하기
        if(N == 0) {
            System.out.println("0");
            return;
        }

        //점수들의 개수가 들어갈 배열 초기화
        for(int i = 1; i <= 30; i++){
            scores[i] = 0;
        }

        //0이 아닌 경우 숫자들을 읽어들이기
        for(int i = 0; i < N; i++) {
            scores[scan.nextInt()]++;
        }

        //평균 구하기
        for(int i = 1; i <= 30; i++){
            sum += scores[i] * i;
        }

        int temp = range;
        for(int i = 1; temp > 0 && i <= 30; i++){
            if(scores[i] > temp){
                sum -= temp * i;
            } else {
                sum -= scores[i] * i;
            }
            temp -= scores[i];
        }

        temp = range;
        for(int i = 30; temp > 0 && i > 0; i--){
            if(scores[i] > temp){
                sum -= temp * i;
            } else {
                sum -= scores[i] * i;

            }
            temp -= scores[i];
        }


        score = (int)Math.round((double)sum / (N - range * 2));

        //출력하기
        System.out.println(score);


    }
}
