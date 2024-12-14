package silver.silver5;

import java.util.Scanner;
public class 성공231228_나이순정렬_10814 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Member temp;
        EachAge[] list = new EachAge[200];

        for(int i = 0; i < 200; i++){
            list[i] = new EachAge(i+1);
        }

        for(int i = 0; i < N; i++){
            temp = new Member(scan.nextInt(), scan.nextLine().trim());
            list[temp.age - 1].add(temp);
        }

        for(int i = 0; i < 200; i++){
            list[i].show();
        }
    }
    public static class Member{
        public int age;
        public String name;
        public Member next;
        Member(int age, String name){
            this.age = age;
            this.name = name;
            next = null;
        }
    }
    public static class EachAge{
        public int age;
        public Member front;
        public Member rear;
        public EachAge(int age){
            this.age = age;
            front = null;
            rear = null;
        }
        public void add(Member m){
            if(front == null){
                front = m;
                rear = m;
            } else {
                rear.next = m;
                rear = m;
            }
        }
        public void show(){
            Member cur = front;

            while(cur != null){
                System.out.println(cur.age + " " + cur.name);
                cur = cur.next;
            }
        }
    }
}
/*
10
20 aaaa
43 ddddddd
42 sdddd
20 ddddddddd
21 ggggggg
52 ddddddddd
18 dddddddddd
27 fffffffffff
30 ddddddddddd
16 dddddddddddd
*/
