package algorithm.graph;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphSearch {
    static public class Graph{
        private List<List<Integer>> nodes;

        public Graph(){
            nodes = new LinkedList<>();
        }
        public void addNode(){
            nodes.add(new LinkedList<>());
        }

        public void addEdge(int node1, int node2){
            nodes.get(node1).add(node2);
            //nodes.get(node2).add(node1);
        }
        public int Dfs(int start, int target){
            boolean visited[] = new boolean[nodes.size()];
            //System.out.println("노드의 수: " + nodes.size());
            int result = findToUseDFS(start, target, visited);

            return result;
        }

        private int findToUseDFS(int start, int target, boolean visited[]){
            System.out.println("현재 노드: " + start);
            visited[start] = true;
            int result = -1;
            if(target == start){
                return start;
            }

            for(int near: nodes.get(start)){
                if(!visited[near]){
                    result = findToUseDFS(near, target, visited);
                }
                if(result != -1){
                    return result;
                }
            }
            return result;
        }
        public int Bfs(int start, int target){
            boolean visisted[] = new boolean[nodes.size()];
            int result = findToUseBFS(start, target, visisted);

            return result;
        }

        public int BFS(int start, int target){
            System.out.println("현재 노드: " + start);

            if(start == target){
                return start;
            }

            boolean visited[] = new boolean[nodes.size()];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);

            while(!queue.isEmpty()){
                int cur = queue.poll();
                if(cur == target){
                    return cur;
                }

                for(int near : nodes.get(cur)){
                    if(!visited[near]){
                        System.out.println("현재 노드: " + near);
                        if(near == target){
                            return near;
                        }

                        queue.add(near);
                        visited[near] = true;
                    }
                }

            }
            return -1;
        }

        private int findToUseBFS(int start, int target, boolean[] visited){
            int result = -1;
            visited[start] = true;

            if(start == target){
                return start;
            }

            for(int near : nodes.get(start)){
                if(!visited[near]){
                    System.out.println("현재 노드: " + near);
                    if(near == target){
                        return near;
                    }
                }
            }

            for(int near : nodes.get(start)){
                if(!visited[near]){
                    result = findToUseBFS(near, target, visited);
                    if(result == target){
                        return result;
                    }
                }
            }
            return result;
        }
    }


    public static void main(String args[]){
        Graph graph = new Graph();

        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 6);
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);
        graph.addEdge(1, 8);
        graph.addEdge(2, 4);
        graph.addEdge(2, 6);
        graph.addEdge(2, 7);
        graph.addEdge(2, 8);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 7);
        graph.addEdge(3, 9);
        graph.addEdge(4, 2);
        graph.addEdge(4, 0);
        graph.addEdge(4, 6);
        graph.addEdge(4, 9);
        graph.addEdge(4, 8);
        graph.addEdge(5, 2);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(5, 8);
        graph.addEdge(6, 1);
        graph.addEdge(6, 3);
        graph.addEdge(6, 7);
        graph.addEdge(7, 1);
        graph.addEdge(7, 4);
        graph.addEdge(7, 8);
        graph.addEdge(8, 2);
        graph.addEdge(8, 0);
        graph.addEdge(8, 4);
        graph.addEdge(9, 2);
        graph.addEdge(9, 5);
        graph.addEdge(9, 7);


        int start = 4, target = 1;

        System.out.println("DFS 시작: " + start + ", 타겟: " + target);
        int result = graph.Dfs(start, target);

        System.out.println("DFS 탐색완료!!");

        System.out.println("BFS 시작: " + start + ", 타겟: " + target);
        result = graph.BFS(start, target);

        System.out.println("DFS 탐색완료!!");
    }
}
