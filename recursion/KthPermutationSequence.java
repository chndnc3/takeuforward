package takeUforward.recursion;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {
    public static void main(String[] args) {
        int n = 4;
        int k = 17;
        String result = findKthPermutationSquence(n, k);
        System.out.println(result);
    }

    private static String findKthPermutationSquence(int n, int k) {
        String ans = "";
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<=n; i++){
            fact = fact * i;
            numbers.add(i);
        }
        fact = fact/numbers.size();
        k = k-1;
        while(true){
            ans = ans + numbers.get(k / fact);
            numbers.remove(k/fact);
            if(numbers.size()==0){
                break;
            }
            k = k%fact;
            fact = fact/numbers.size();
        }
        return ans;
    }
}
