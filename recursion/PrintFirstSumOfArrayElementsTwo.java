package takeUforward.recursion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrintFirstSumOfArrayElementsTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] elements = new int[size];
        for(int i=0; i<size; i++){
            elements[i] = sc.nextInt();
        }

        int sum = 0;
        int two = 2;
        Deque<Integer> list = new ArrayDeque<>();

        printFirstSumOfArrayElementsTwo(0, list, elements, size, sum, two);
    }

    private static boolean printFirstSumOfArrayElementsTwo(int index, Deque<Integer> list, int[] elements, int size, int sum, int two) {
        if(index == size){
            if(sum==two){
                System.out.println(list);
                return true;
            } else {
                return false;
            }
        }

        sum += elements[index];
        list.push(elements[index]);
        if(printFirstSumOfArrayElementsTwo(index+1, list, elements, size, sum, two)==true){
            return true;
        }

        sum -= elements[index];
        list.pop();
        if(printFirstSumOfArrayElementsTwo(index+1, list, elements, size, sum, two)==true){
            return true;
        }
        return false;
    }
}
