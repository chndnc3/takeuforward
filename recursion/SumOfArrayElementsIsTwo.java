package takeUforward.recursion;

import java.text.NumberFormat;
import java.util.*;

public class SumOfArrayElementsIsTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Integer[] elements = new Integer[size];
        for (int i = 0; i<size; i++){
            elements[i] = sc.nextInt();
        }
        int two = 2;
        int sum = 0;
        Deque<Integer> ds = new ArrayDeque<>();
        printSubArrayWhoseSumIsTwo(0, ds, elements, size, two, sum);
    }

    private static void printSubArrayWhoseSumIsTwo(int i, Deque<Integer> ds, Integer[] elements, int size, int two, int sum) {
        if(i==size){
            if(sum==two){
                System.out.println(ds);
            }
            return;
        }
        ds.push(elements[i]);
        sum += elements[i];
        printSubArrayWhoseSumIsTwo(i+1, ds, elements, size, two, sum);
        sum -= elements[i];
        ds.pop();
        printSubArrayWhoseSumIsTwo(i+1, ds, elements, size, two, sum);

    }

    static class CurrencyFormat {
        public static void main(String[] args) {
            // **********Currenct to Float/Dollar*****
            double money = Double.parseDouble("$2,480,567,789.67".replaceAll("[^\\d.]", ""));
            System.out.println(money);


            // *******Float/Dollar to Currency*********
            double currencyAmount = money;
            // Create a new Locale
            Locale usa = new Locale("en", "US");
            // Create a Currency instance for the Locale
            Currency dollars = Currency.getInstance(usa);
            // Create a formatter given the Locale
            NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);

            // Format the Number into a Currency String
            System.out.println(dollars.getDisplayName() + ": " + dollarFormat.format(currencyAmount));
        }
    }
}
