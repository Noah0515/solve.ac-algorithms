package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 성공250925_경로찾기_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] result = new int[N][N];
        String[] line;
        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (line[j].charAt(0) - '0' != 0){
                    nodes[i].addLink(nodes[j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int[] isLinked = new int[N];
            Node cur = nodes[i];
            search(cur, isLinked);
            result[i] = isLinked.clone();

        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }



    }

    public static void search(Node node, int[] isLinked) {
        for(Node n : node.linked){
            int temp_id = n.id;
            if (isLinked[temp_id] == 0){
                isLinked[temp_id] = 1;

                search(n, isLinked);
            }
        }
    }

    public static class Node{
        LinkedList<Node> linked;
        int id;

        public Node(int id){
            linked = new LinkedList<Node>();
            this.id = id;
        }

        public void addLink(Node node){
            linked.add(node);
        }

    }

}
