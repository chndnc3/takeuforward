package takeUforward.recursion;

import java.util.*;

public class SubSetSumI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        for(int i=0; i<length; i++){
            array[i]=sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        sumListFun(0, 0, array, list, length);
        Collections.sort(list);
        System.out.println(list);
    }

    private static void sumListFun(int index, int sum, int[] array, List<Integer> list, int length) {
        if(index==length){
            list.add(sum);
            return;
        }
        sumListFun(index+1, sum+array[index], array, list, length);
        sumListFun(index+1, sum, array, list, length);
    }
}
