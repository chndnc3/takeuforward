package takeUforward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for(int i=0;i<size;i++){
            array[i]=sc.nextInt();
        }
        quickSort(array, 0, array.length-1);
        Arrays.stream(array).forEach(e -> System.out.print(e+" "));
    }

    private static void quickSort(int[] array, int low, int high) {
        if(low < high){
            int partition = partition(array,low,high);
            quickSort(array,low,partition-1);
            quickSort(array,partition+1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;
        int j = high;
        while(i<j){
            while(array[i] <= pivot && i <= high-1){
                i++;
            }
            while(array[j] > pivot && j >= low+1){
                j--;
            }
        }
        if(i<j){
            swap(array, i, j);
        }
        swap(array, low, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
