package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class 성공250918_연결요소의개수_11724 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line;
        int N, M;
        int group = 0;

        try {
            line = br.readLine().split(" ");
        } catch (IOException e){
            throw new RuntimeException();
        }
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        boolean[] checked = new boolean[N+1];
        for (boolean n : checked){
            n = false;
        }

        Node[] nodes = new Node[N+1];

        for(int i = 0; i <= N; i++){
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < M; i++){
            int x, y;
            try {
                line = br.readLine().split(" ");
                x = Integer.parseInt(line[0]);
                y = Integer.parseInt(line[1]);
            } catch (IOException e){
                throw new RuntimeException();
            }

            nodes[x].addLink(nodes[y]);
            nodes[y].addLink(nodes[x]);

        }

        for(int i = 1; i <= N; i++){
            if (!checked[i]){
                findLinked(nodes[i], checked);
                group += 1;
            }
        }

        System.out.println(group);

    }

    public static void findLinked(Node cur, boolean[] checked){
        int id = cur.id;
        if(checked[id]){
            return;
        } else {
            checked[id] = true;
        }

        for(Node n : cur.linked){
            findLinked(n, checked);
        }

    }
    public static class Node {
        public List<Node> linked;
        public int id;
        public Node(int id){
            linked = new LinkedList<Node>();
            this.id = id;
        }

        public void addLink(Node n){
            linked.add(n);
        }
    }
}
