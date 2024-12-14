package silver.silver4;

import org.w3c.dom.Node;

import java.util.Scanner;
import java.util.Stack;

public class 스택_10828 {
    public  void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String str;
        MyStack stack = new MyStack();

        for(int i = 0; i < N; i++){
            str = scan.nextLine();
           // if(str)
        }

    }
    public class MyStack{
        protected Node top;
        protected int size;
        public MyStack(){
            top = null;
            size = 0;
        }

        public void push(int num){
            Node temp = new Node(num);
            temp.before = top;
            top = temp;
            size++;
        };
        public int pop(){
            if(size == 0){
                return -1;
            } else {
                int temp = top.data;
                top = top.before;
                size--;
                return temp;
            }
        };
        public int size(){
            return size;
        };
        public int empty(){
            if(size == 0){
                return 1;
            } else {
                return 0;
            }
        };
        public int top(){
            return top.data;
        };
    }
    public class Node{
        Node before;
        int data;
        public Node(int num){
            before = null;
            data = num;
        }
    }
}
