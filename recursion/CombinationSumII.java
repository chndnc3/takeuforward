package takeUforward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSumII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] candidates = new int[length];
        for(int i=0; i<length; i++){
            candidates[i]=sc.nextInt();
        }
        int target = sc.nextInt();
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        getCombinationII(0, candidates, target, combinations, new ArrayList<>());
        System.out.println(combinations);
    }

    private static void getCombinationII(int index, int[] candidates, int target, List<List<Integer>> combinations, ArrayList<Integer> subCombination) {
        if(target == 0){
            combinations.add(new ArrayList<>(subCombination));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            subCombination.add(candidates[i]);
            getCombinationII(i+1, candidates, target-candidates[i], combinations, subCombination);
            subCombination.remove(subCombination.size()-1);
        }
    }
}
