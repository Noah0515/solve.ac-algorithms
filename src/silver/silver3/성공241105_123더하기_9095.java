package silver.silver3;
/*
아이디어1: 이건 막대자르기문제임. queue를 이용해 bfs로 풀면 되지 않을까?
덧셈을 리스트로 저장하자. 1 + 3 + 2는 리스트로 1->3->2. 이 리스트를 가지고 해시에 넣으면 중복되는 값이 없을거니까
문제는 덧셈의 각 항이 1,2,3밖에 안된다는 조건임. 그러면 다른 생각을 해보자
아이디어2: 끝에서부터 계산의 종류를 찾아내는 방식을 선택하자
7=1+1+1+1+1+1+1이니까 뒤에서부터 경우의 수를 구함
뒷1 1=1; 1
뒷2 2=2, 2=1+1; 2
뒷3 3=3, 3=2+1, 3=1+2, 3=1+1+1; 4
뒷4 4=1+뒷3, 4=2+뒷2, 4=3+뒷1 = 7
뒷5 5=1+뒷4 5=2+뒷3, 5=3+뒷2; 13
2 3
3 2
3 1 1
2 1 1 1
1 2 1 1
1 3 1
1 1 2 1
1 1 3
1 1 1 2
2 2 1
2 1 2
1 2 2
1 1 1 1 1   //이거 가능한듯

1. 아이디어2를 채용하니 접근방식은 맞는 것 같다. 근데 배열쪽에서 runtimeerror가 뜨는걸 보면 어딘가 문제가 있는듯.


 */
import java.util.Scanner;

public class 성공241105_123더하기_9095 {
    public static int calFindOfAdd(int n) {
        //n값에 따라 count의 크기 조절하고, 기본값 초기화
        int[] count;
        if(n <= 3)
            count = new int[4];
        else
            count = new int[n+1];

        count[0] = 0;
        count[1] = 1;
        count[2] = 2;
        count[3] = 4;

        //n의 덧셈 방법 구하기
        for (int i = 4; i <= n; i++) {
            count[i] = count[i-3] + count[i-2] + count[i-1];
        }

        return count[n];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println(calFindOfAdd(scan.nextInt()));

        }

    }
}
