package silver.silver4;

//직접 만들어 구현한 퀵소트와 직접 만들어 이진 탐색을 사용했지만 시간초과가 났다.
//어쩔 수 없이 Arrays.sort()를 사용했고 성공은 했다.
//나중에 퀵소트보다 더 좋은 정렬 알고리즘을 구현해보는 연습을 한번쯤을 하는게 좋을 것 같다.
//퀵소트도 만드는데 아주 큰 어려움을 겪었다. 이것도 나중에 다시한번 만들어 보는게 좋을 것 같다. O(n^2)의 시간복잡도를 갖는 정렬을 만드는 것은 이미 잘 할 수 있으니까.

import java.util.Arrays;
import java.util.Scanner;

public class 성공240105_수찾기_1920 {
    public static int count = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m, t;
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        //sort(nums, 0, n-1);
        m = scan.nextInt();
        for(int i = 0; i < m; i++){
            if(isInclude(nums, 0, n-1, scan.nextInt())){
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
    public static boolean isInclude(int[] array, int min, int max, int target){
        if(min > max) {
            return false;
        }
        int pivot = (min + max) / 2;
        if(target == array[pivot]){
            return true;
        } else if (target < array[pivot]){
            return isInclude(array, min, pivot - 1, target);
        } else {
            return isInclude(array, pivot + 1, max, target);
        }
    }
    public static void sort(int[] array, int start, int end){ // 퀵소트 구현성공!!!!!!!!!!!!
        count++;
        int pivot = (start + end) / 2;
        int value = array[pivot];
        int last = start, temp;

        if(start >= end){
            return;
        }
        for(int i = start; i <= end; i++){
            if(array[i] < value){
                temp = array[i];
                array[i] = array[last];
                array[last] = temp;

                if(pivot == last && i > pivot){
                    pivot = i;
                }
                last++;
            }
        }

        if(last == start){
            //pivot에 해당하는게 가장 작은 경우
            temp = array[last];
            array[last] = array[pivot];
            array[pivot] = temp;
        } else if(last < pivot) {
            temp = array[last];
            array[last] = array[pivot];
            array[pivot] = temp;
        }

        sort(array, start, last - 1);
        sort(array,last + 1, end);
    }
}
