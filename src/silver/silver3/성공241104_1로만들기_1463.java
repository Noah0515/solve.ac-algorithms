package silver.silver3;
/*아이디어
1.
10 -> 9 -> 3 -> 1 을 참고하여 n-1이 3으로 나누어 떨어지면 1을 빼는걸 가장 먼저 고려하고 그 뒤로는 상식순으로
29 -> 28 -> 27 -> 9 -> 3 -> 1; 5
29 -> 28 -> 14 -> 7 -> 6 -> 2 -> 1; 6
**실패**

2.
11 -> 10 -> 9 -> 3 -> 1; 4
40 -> 39 -> 13 -> 12 -> 4 -> 3 -> 1;6
40 -> 20 -> 10 -> 9 -> 3 -> 1; 5 이 경우에 안됨.(3으로 나누어 떨어지지 않고, 4로 나눠지는 경우)
76 -> 75 -> 25 -> 24 -> 8 -> 4 -> 3 -> 1;7
76 -> 38 -> 19 -> 18 -> 6 -> 2 -> 1;
=>가장 먼저 4로 나누ㅜ어 떨어지는 경우룰 추가하자.
**5% 실패** 4로 나눠떨어질 때 3으로는 나누어 떨어지지 않는 경우를 추가하자

 3.
 3으로 나누어 떨어지지 않고 4로 나누어 떨어지는 경우를 추가했지만 **5% 실패**

접근방식을 아예 고쳐서 시도함.
기존에는 n에서 1로 가는 방식으로 x를 찾았다면 이번엔 1에서 n을 찾는 방식으로 x를 찾음.
(1)각 노드에 숫자와 횟수를 적어 queue에 집어넣음.
(2)queue에 들어온 순서대로 다음에 올 +1, *2, *3 숫자를 찾음. queue에 들어있는 노드들은 무조건 앞의 노드가 작은 x값을 가짐.
만약 n까지 도달하면 끝
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 성공241104_1로만들기_1463 {
    public static class Node{
        public Node(int num, int x){
            this.num = num;
            this.x = x;
        }
        public int num;
        public int x;
        public Node one;
        public Node two;
        public Node three;
        public boolean isleaf = false;
    }

    public static void main(String[] args){
        //변수
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = 0, temp;
        int[] cost = new int[n+1];
        cost[1] = 0;
        Queue<Node> queue = new LinkedList<>();
        Node cur;
        Node first = new Node(1,0);
        queue.add(first);


        //알고리즘
        while(!queue.isEmpty()){
            //맨 위 큐 빼기
            cur = queue.poll();
            temp = cur.num;
            x = cur.x;
           // System.out.println("현재 노드의 값: " + temp + ", 횟수: " + x);

            if(temp + 1 <= n && cost[temp + 1] == 0){
                Node t = new Node(temp + 1, x + 1);
                cost[temp + 1] = x + 1;
                //System.out.println("숫자: " + (temp+1) + ", 횟수: " + cost[temp+1]);
                queue.add(t);
            }

            if(temp * 2 <= n && cost[temp * 2] == 0){
                Node t = new Node(temp * 2, x + 1);
                cost[temp * 2] = x + 1;
                //System.out.println("숫자: " + (temp*2) + ", 횟수: " + cost[temp*2]);
                queue.add(t);
            }

            if( temp * 3 <= n && cost[temp * 3] == 0 ){
                Node t = new Node(temp * 3, x + 1);
                cost[temp * 3] = x + 1;
                //System.out.println("숫자: " + (temp*3) + ", 횟수: " + cost[temp*3]);
                queue.add(t);
            }

            if(cost[n] != 0){
                break;
            }
        }


        System.out.println(cost[n]);
    }


}
