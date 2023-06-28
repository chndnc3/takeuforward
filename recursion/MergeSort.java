package takeUforward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] elements = new int[size];
        for(int i=0; i<size; i++){
            elements[i] = sc.nextInt();
        }

        funMergeSort(elements, 0, size-1);
        Arrays.stream(elements).forEach(e -> System.out.print(e+" "));
    }

    private static void funMergeSort(int[] elements, int low, int high) {
        if(low==high){
            return;
        }
        int mid = (low+high)/2;
        funMergeSort(elements, low, mid);
        funMergeSort(elements, mid+1, high);
        merge(elements, low, high, mid);
    }

    private static void merge(int[] elements, int low, int high, int mid) {
        int left = low;
        int right = mid+1;
        List<Integer> sorted = new ArrayList<>();


        while(left <= mid && right <= high){
            if(elements[left] <= elements[right]){
                sorted.add(elements[left]);
                left++;
            } else{
                sorted.add(elements[right]);
                right++;
            }
        }

        while(left <= mid){
            sorted.add(elements[left]);
            left++;
        }

        while(right <= high){
            sorted.add(elements[right]);
            right++;
        }

        for(int i = low; i<=high; i++){
            elements[i] = sorted.get(i-low);
        }
    }
}
