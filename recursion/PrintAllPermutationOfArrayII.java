package takeUforward.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintAllPermutationOfArrayII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        for(int i=0; i<length; i++){
            array[i]=sc.nextInt();
        }
        List<List<Integer>> answer = new ArrayList<>();
        permute(0, array, answer);
        System.out.println(answer);
    }

    private static void permute(int index, int[] array, List<List<Integer>> answer) {
        if(index==array.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<array.length; i++){
                ds.add(array[i]);
            }
            answer.add(ds);
            return;
        }
        for(int i=index; i<array.length; i++){
            swap(i, index, array);
            permute(index+1, array, answer);
            swap(i, index, array);
        }
    }

    private static void swap(int i, int j, int[] array) {
        int tmp = array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
}
