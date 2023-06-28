package takeUforward.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class CountOfSubArraysWhoseSumIsTwo {
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
        System.out.println(countOfSubArraysWhoseSumIsTwo(0, list, elements, size, sum, two));
    }

    private static int countOfSubArraysWhoseSumIsTwo(int index, Deque<Integer> list, int[] elements, int size, int sum, int two) {
        if(sum>two){ //two reduce time complexity by little bit and value is strictly positive
            return 0;
        }
        if(index==size){
            if(sum==two){
                return 1;
            } else{
                return 0;
            }
        }

        sum += elements[index];
        list.push(elements[index]);
        int l = countOfSubArraysWhoseSumIsTwo(index+1, list, elements, size, sum, two);

        sum -= elements[index];
        list.pop();
        int r = countOfSubArraysWhoseSumIsTwo(index+1, list, elements, size, sum, two);

        return l+r;
    }
}
