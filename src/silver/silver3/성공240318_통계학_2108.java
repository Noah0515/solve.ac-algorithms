package silver.silver3;

/*
1.47%에서 틀림(????) 시간초과는 없는듯
2.반올림을 Math를 이용해 해봤지만 2%에서 실패 -> 반올림 알고리즘은 직접 만들어서 쓰자
3.Math안에 나누기에 (double)을 추가해주니 1번에서와 같은 결과(47%쯤에서 실패)나 나왔다. 내가 기존에 만들었던 반올림 과정에는 문제가 없는것으로 판단된다.
4.마지막 인덱스 처리를 수정하고 성공!!!!
*/
import java.util.Arrays;
import java.util.Scanner;

public class 성공240318_통계학_2108 {
    public static void main(String args[]){
        //변수 선언
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), sum = 0, count1 = 1, count2 = 0, mode1, mode2, cur_count = 1;
        double avg;
        int[] numbers = new int[N];
        //입력
        for(int i = 0; i < N; i++){
            numbers[i] = scan.nextInt();
            sum += numbers[i];
        }

        //산술 평균 성공
        System.out.println(Math.round((double)sum/N));
        //System.out.println(sum/N + (sum % N) / ((N + 1) / 2));

        //중앙값 성공
        Arrays.sort(numbers);
        System.out.println(numbers[N/2]);

        //최빈값 -> 이놈이 문제(예제입력3에서 문제있음) -> (예제입력 3을 성공하긴 했는데 예제입력 1에서 틀림? 최빈값이 같을 경우 3번째로 작은게 튀어나옴??)
        //최빈값 초기화
        mode1 = numbers[N-1];
        mode2 = numbers[N-1];
        //최빈값 구하는 과정
        for(int i = N-2; i >= 0; i--){//맨 뒤 인덱스부터 거꾸로 확인하기
            if(numbers[i] == numbers[i+1]){
                cur_count++;
            } else {
                if(cur_count > count1){
                    count1 = cur_count;
                    mode1 = numbers[i+1];

                } else if(cur_count == count1){
                    count2 = count1;
                    mode2 = mode1;
                    mode1 = numbers[i+1];
                }

                cur_count = 1;
            }
        }
        /*
        오류가 나서 생각을 해본 결과 최빈값을 구하는 방식의 수적이 필요해보인다.
        제일 작은 숫자가 중복되는 최빈값일 경우 제대로 작동하지 않을 가능성이 보인다.
        이는 현재 인덱스와 이전 인덱스와 비교하고 초건에 따라 최빈값을 설정할 때 이전 인덱스가 설정되게 만들었기 때문으로 추정된다.
        프로그램의 속도가 조금 느려지더라도 최빈값은 현재 인덱스로 설정할 수 있는 알고리즘으로 수정해야된다.
        (왜 최빈값은 중복일 경우 두번째로 작은 숫자를 출력하도록 하였을까???)
         */
        if(cur_count == count1){//마지막 인덱스 처리를 수정한 부분. 예제 테스트는 모두 통과
            mode2 = mode1;
        }

        if(count1 == count2){ //최빈값이 중복인 경우
            System.out.println(mode2); //두번째로 작은 최빈값 출력
        } else { //최빈값이 1개인 경우
            System.out.println(mode1); //그냥 최빈값 출력
        }

        //범위 성공
        System.out.println(numbers[N-1] - numbers[0]);
    }
}
