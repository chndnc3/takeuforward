package takeUforward.recursion;

import java.util.*;

public class PrintSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer size = sc.nextInt();
        Integer elements[] = new Integer[size];
        for(int i = 0; i< size; i++){
            elements[i] = sc.nextInt();
        }
        Deque<Integer> list = new ArrayDeque<>();
        printSubSequences(0, list, elements);
    }

    private static void printSubSequences(int i, Deque<Integer> list, Integer[] elements) {
        if(i == elements.length){
            System.out.println(list);
            return;
        }
        list.push(elements[i]);
        printSubSequences(i+1, list, elements);
        list.pop();
        printSubSequences(i+1, list, elements);
    }
}
