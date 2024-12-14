package algorithm.assignment5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CoinToss {
    public static class Node{
        public boolean[] coin;
        public int end;
        public int k;
        public Node(int n){
            coin = new boolean[n];
            end = -1;
            k = 0;
        }
        public Node(int n, Node parent, boolean next){
            coin = new boolean[n];
            end = parent.end + 1;

            System.arraycopy(parent.coin, 0, coin, 0, n);
            coin[end] = next;
            if(next){
                k = parent.k + 1;
            } else{
                k = parent.k;
            }
        }

        public void printResult(){
            int size = coin.length;

            for(int i = 0; i <= end; i++){
                if(coin[i]){
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }

            }

            for(int i = end+1; i < size; i++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Search(scan.nextInt(), scan.nextInt());
    }

    public static void Search(int n, int k){
        Queue<Node> tree = new LinkedList<>();
        Node cur;
        Node root = new Node(n);
        tree.add(root);

        while(!tree.isEmpty()){
            cur = tree.poll();

            if(cur.k == k && cur.end == n-1){
                cur.printResult();
            }

            if(cur.k > k || cur.k + n - cur.end - 1 < k || cur.end >= n-1){
            //가지치기의 경우이므로 가지를 방문하지 않는다.
            } else {
                tree.add(new Node(n, cur, false));
                tree.add(new Node(n, cur, true));
            }
        }
    }
}
