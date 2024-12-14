package silver.silver5;

import java.util.Scanner;

public class 성공231228_요세푸스문제0_11866 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        String result = "";
        Number first = new Number(1);
        Number last = first;
        Number temp;

        for(int i = 2; i <= n; i++){
            temp = new Number(i);
            last.add(temp);
            last = temp;
        }
        last.next = first;
        first.before = last;

        temp = last;
        result += "<";
        while(temp != null){
            for(int i = 0; i < k; i++){
                temp = temp.next;
            }
            result += Integer.parseInt(String.valueOf(temp.num)) + ", ";
            temp = temp.delete();
        }
        result = result.substring(0, result.length() - 2);
        result += ">";
        System.out.println(result);
    }
    public static class Number{
        int num;
        Number next;
        Number before;
        public Number(int n){
            num = n;
            next = null;
            before = null;
        }
        public void add(Number n){
            next = n;
            n.before = this;
        }
        public Number delete(){
            if(before != this){
                before.next = next;
                next.before = before;
                return before;
            } else {
                before = null;
                next = null;
                return null;
            }
        }

    }
}
