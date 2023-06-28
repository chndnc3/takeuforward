package takeUforward.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// It takes more space complexity.
public class PrintAllPermutationOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        for(int i=0; i<length; i++){
            array[i]=sc.nextInt();
        }
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] freq = new boolean[length];
        permute(array,answer, new ArrayList<>(), freq);
        System.out.println(answer);
    }

    private static void permute(int[] array, List<List<Integer>> answer, ArrayList<Integer> ds, boolean[] freq) {
        if(ds.size()==array.length){
            answer.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0; i<array.length; i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(array[i]);
                permute(array, answer, ds, freq);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
}
