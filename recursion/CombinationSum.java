package takeUforward.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] candidates = new int[length];
        for(int i=0;i<length;i++){
            candidates[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        List<List<Integer>> combinations = new ArrayList<>();
        getCombinations(0, candidates, target, combinations, new ArrayList<>());
        System.out.println(combinations);
    }

    private static void getCombinations(int index, int[] candidates, int target, List<List<Integer>> combinations, ArrayList<Integer> subCombination) {
        if(index==candidates.length){
            if(target==0){
                combinations.add(new ArrayList<>(subCombination));
            }
            return;
        }
        if(candidates[index] <= target){
            subCombination.add(candidates[index]);
            getCombinations(index, candidates, target-candidates[index], combinations, subCombination);
            subCombination.remove(subCombination.size()-1);
        }
        getCombinations(index+1, candidates, target, combinations, subCombination);
    }
}
