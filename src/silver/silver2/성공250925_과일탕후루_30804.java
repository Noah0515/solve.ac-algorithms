package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 성공250925_과일탕후루_30804 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        int N;
        int[] tanghulu; // 입력값

        try {
            line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            tanghulu = new int[N];
            line = br.readLine().split(" ");

        } catch (IOException e){
            throw new RuntimeException(e);
        }

        for(int i = 0; i < N; i++){
            tanghulu[i] = Integer.parseInt(line[i]);
        }


        Skew skew = new Skew(new Fruit(tanghulu[0]));

        for(int i = 1; i < N; i++){
            skew.addFruit(new Fruit(tanghulu[i]));
        }


        System.out.println(skew.max);
    }

    public static class Fruit {
        public int id; // 어떤 과일인지
        public int index; // 몇번째 과일인지.
        public Fruit next;
        public Fruit prev;
        public Fruit(int id) {
            this.id = id;
        }
    }

    public static class Skew {
        public Fruit head;
        public Fruit tail;
        public int num; //지금까지 몇개 꽃았는지
        public int max;

        public HashMap<Integer, Integer> kinds;
        public Skew(Fruit first){
            kinds = new HashMap<>();
            head = first;
            tail = first;
            num = 1;
            max = 1;
            kinds.put(first.id, first.id);
            head.next = null;
            head.prev = null;
            tail.next = null;
            tail.prev = null;
            first.index = 1;
        }

        public void addFruit(Fruit fruit){
            fruit.index = ++num;
            if (kinds.containsKey(fruit.id)){ // 이미 꽃힌 과일이 다시 꽃히는 경우
                head.next = fruit;
                fruit.prev = head;
                head = fruit;

                max = Math.max(max, head.index - tail.index + 1);
            } else if (kinds.size() < 2){ // 꽃힌 과일의 개수가 1개인 경우
                head.next = fruit;
                fruit.prev = head;
                head = fruit;
                kinds.put(fruit.id, fruit.id);

                max = Math.max(max, head.index - tail.index + 1);
            } else {    // 꽃인 과일의 개수가 2개인 경우
                Fruit cutted = cut(fruit.id);
                max = Math.max(max, head.index - tail.index + 1);
                int temp = num - cutted.index + 1;

                head.next = fruit;
                fruit.prev = head;
                head = fruit;

                kinds.remove(cutted.id);
                kinds.put(fruit.id, fruit.id);

            }
            //System.out.println("head: " + head.index + ", tail: " + tail.index + ", max = " + max);
        }

        public Fruit cut(int id){
            Fruit temp = head;
            Fruit cutted = null;
            int id1 = temp.id;
            while(temp != null){
                if (temp.id == id1){
                    temp = temp.prev;
                } else {
                    cutted = temp;
                    tail = cutted.next;
                    temp.next.prev =null;
                    break;
                }
            }
            //System.out.println("잘린 과일의 정보 # 아이디: " + cutted.id + ", 순서: " + cutted.index);
            return cutted;
        }
    }
}
