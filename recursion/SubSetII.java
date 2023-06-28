package takeUforward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubSetII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        for(int i=0; i<length; i++){
            array[i]=sc.nextInt();
        }
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(array);
        sumListFunII(0, array, length, list, new ArrayList<>());
        System.out.println(list);
    }

    private static void sumListFunII(int index, int[] array, int length, List<List<Integer>> list, ArrayList<Integer> subSet) {
        list.add(new ArrayList<>(subSet));
        for(int i=index; i<length; i++){
            if(i!=index && array[i]==array[i-1]){
                continue;
            }
            subSet.add(array[i]);
            sumListFunII(i+1, array, length, list, subSet);
            subSet.remove(subSet.size()-1);
        }
    }
}
