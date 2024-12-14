package silver.silver3;
/*
아이디어: 그래프를 사용해서 해보자. 링크드리스트를 사용하여 인접행렬그래프를 구현하자.
시작node를 queue에 넣고 해당 node와 연결된 node들을 차례차례 queue에 넣음.
queue에 넣을때마다 감염여부를 확인하는 배열에 표기
queue가 비면 끝. 표시한 node의 개수가 답

1. 1트에 성공
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 성공241105_바이러스_2606 {
    public static void main(String[] args){
        //변수선언
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int n = scan.nextInt();
        int s, d, x = 0;
        boolean[] isinfection = new boolean[total + 1];
        LinkedList<Integer> cur;
        LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
        Queue<LinkedList<Integer>> queue = new LinkedList<>();

        //그래프의 모든 node를 저장
        for(int i = 0; i <= total; i++){ //링크드리스트도 처음 node가 0이니까 편하게 하기 위해 1개 더 만들기
            graph.add(new LinkedList<>());
        }

        //정점들을 연결
        for(int i = 0; i < n; i++){
            s = scan.nextInt();
            d = scan.nextInt();

            graph.get(s).add(d);
            graph.get(d).add(s);
        }

        //1번컴퓨터와 연결된 컴퓨터들 찾기
        isinfection[1] = true;
        queue.add(graph.get(1));

        while(!queue.isEmpty()) {
            cur = queue.poll();
            for (int i : cur) {
                if (isinfection[i] == false) {
                    isinfection[i] = true;
                    x++;
                    queue.add(graph.get(i));
                }
            }
        }
        System.out.println(x);
    }
}
