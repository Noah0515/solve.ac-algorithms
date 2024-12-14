package silver.silver4;

//arraylist를 이용한1번 제출은 시간초과
//이진트리로 알고리즘을 변화시켜보자!!! -> 이건 1% 후 시간초과

import java.util.Scanner;
public class 숫자카드2_10816 {
    public static void main(String[] args){
        //트리를 표현할 노드
        class Node{
            public int num;
            public int count;
            public Node left;
            public Node right;
            public Node(int num){
                this.num = num;
                count = 1;
                left = null;
                right = null;
            }

        }
        //필요한 변수들
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), M, cur_num;
        boolean success;//무사히 카드를 추가하거나 갱신한 경우
        Node top = new Node(0), cur_Node;    //효율을 위해 숫자 0을 루트 노드로 미리 선언
        top.count = 0;                            //대신 count를 0으로 ㅇㅋ?

        //숫자카드에 적혀있는 카드 확인하고 저장하기
        for(int i = 0; i < N; i++){
            cur_Node = top;
            cur_num = scan.nextInt();
            success = false;

            //루트부터 카드를 확인하며 저장 혹은 카운트 올리기
            while(!success){
                if(cur_Node.num == cur_num){//현재노드의 숫자와 카드의 숫자가 같은 경우
                    cur_Node.count++;
                    break;
                } else if(cur_Node.num > cur_num){//현재노드의 숫자보다 카드숫자가 작은 경우
                    if(cur_Node.left == null) {//없으면 새 카드 추가
                        cur_Node.left = new Node(cur_num);
                        break;
                    } else {//있으면 다시 반복
                        cur_Node = cur_Node.left;
                    }
                } else {//현재노드의 숫자보다 카드숫자가 큰 경우
                    if(cur_Node.right == null){//없으면 새 카드 추가
                        cur_Node.right = new Node(cur_num);
                        break;
                    } else {//있으면 다시 반복
                        cur_Node = cur_Node.right;
                    }
                }

            }
        }
        M = scan.nextInt();

        //숫자카드에 적혀있는 카드개수 확인하고 출력하기
        for(int i = 0; i < M; i++){
            cur_Node = top;
            cur_num = scan.nextInt();
            success = false;

            //루트부터 카드를 확인하며 출력하기
            while(!success){
                if(cur_Node.num == cur_num){//현재노드의 숫자와 카드의 숫자가 같은 경우
                    System.out.print(cur_Node.count + " ");
                    break;
                } else if(cur_Node.num > cur_num){//현재노드의 숫자보다 카드숫자가 작은 경우
                    if(cur_Node.left == null) {//없으면 0 출력
                        System.out.print(0 + " ");
                        break;
                    } else {//있으면 다시 반복
                        cur_Node = cur_Node.left;
                    }
                } else {//현재노드의 숫자보다 카드숫자가 큰 경우
                    if(cur_Node.right == null){//없으면 0 출력
                        System.out.print(0 + " ");
                        break;
                    } else {//있으면 다시 반복
                        cur_Node = cur_Node.right;
                    }
                }
            }
        }
    }
}
/*arraylist 버전
//변수선언
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), size = 0, cur_num;
        boolean include;
        //카드 클래스
        class Card{
            public int num;
            public int count;
            public Card(int n){
                num = n;
                count = 1;

            }
        }
        //입력받은 숫자카드들을 저장할 카드리스드
        ArrayList<Card> cards = new ArrayList<>();


        //카드저장하는 반복문
        for(int i = 0; i < n; i++){
            //숫자 입력받기
            cur_num = scan.nextInt();
            include = false;

            //중복되는 숫자인지 확인
            for(int j = 0; j < size; j++){
                if(cards.get(j).num == cur_num){
                    include = true;
                    cards.get(j).count++;
                    break;
                }
            }

            //중복이 안되면 카드개수 1증가
            if(!include){
                cards.add(new Card(cur_num));
                size++;
            }
        }


        //해당 숫자카드를 가지고 있는지 확인하는 부분 시작
        //숫자 종류 개수 입력
        int m = scan.nextInt();

        //중복되는 카드가 있는지 검사하고 출력하는 반복문
        for(int i = 0; i < m; i++){
            cur_num = scan.nextInt();
            include = false;
            //System.out.println(cur_num);
            //cur_num과 같은 카드 몇개 가지고 있는지 확인
            for(int j = 0; j < size; j++){
                if(cards.get(j).num == cur_num){
                    include = true;
                    System.out.print(cards.get(j).count + " ");
                    break;
                }
            }
            if(!include){
                System.out.print(0 + " ");
            }
        }
 */
