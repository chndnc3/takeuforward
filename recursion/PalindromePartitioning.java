package takeUforward.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        findPartition(s, 0, path, result);
        System.out.println(result);
    }

    private static void findPartition(String s, int idx, List<String> path, List<List<String>> result) {
        if(s.length()==idx){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx; i<s.length(); i++){
            if(isPalidrome(s, idx, i)){
                path.add(s.substring(idx, i+1));
                findPartition(s, i+1, path, result);
                path.remove(path.size()-1);

            }
        }

    }

    private static boolean isPalidrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
