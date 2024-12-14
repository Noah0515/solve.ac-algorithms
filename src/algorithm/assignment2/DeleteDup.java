package algorithm.assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DeleteDup {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int array[] = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = scan.nextInt();
        }

        int result[] = deleteDuplication(array);

        printArray(result);
    }
    public static int[] deleteDuplication(int array[]){
        int high = array.length - 1;
        mergeSort(array, 0, high);

        int result[];

        result = delDup(array);

        return result;
    }
    public static void mergeSort(int A[], int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);
            merge(A, low, mid, high);
        }

    }
    public static void merge(int A[], int low, int mid, int high){
        int B[] = new int[high + 1];
        int h = low, i = low, j = mid + 1;

        while(i <= mid && j <= high){
            //System.out.println(A[i] + " " + A[j]);
            if(A[i] <= A[j]){
                B[h] = A[i];
                i++;
            } else {
                B[h] = A[j];
                j++;
            }
            h++;
        }

        if(i > mid){
            for(int k = j; k <= high; k++){
                B[h] = A[k];
                h++;
            }
        } else {
            for(int k = i; k <= mid; k++){
                B[h] = A[k];
                h++;
            }
        }

        for(int k = low; k <= high; k++){
            A[k] = B[k];
        }
    }
    public static int[] delDup(int A[]){
        int len = A.length;
        int cur = 1;
        int B[] = new int[len];

        B[0] = A[0];
        for(int i = 1; i < len; i++){
            if(A[i] != B[cur-1]){
                B[cur] = A[i];
                cur++;
            }
        }

        return Arrays.copyOfRange(B, 0, cur);
    }

    public static void printArray(int A[]){
        for(int i = 0; i < A.length; i++){
            System.out.println(A[i]);
        }
    }

    public static void splitDiffMax(int array[], int small[], int big[]){
        int high = array.length - 1;
        mergeSort(array, 0, high);

        int len = array.length;
        int mid = len/2;

        for(int i = 0; i < mid; i++){
            small[i] = array[i];
            big[i] = array[mid + i];
        }

    }
}
