package HomeTask7.Task3;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Service maxNum = (int a, int b, int c) -> Collections.max(Arrays.asList(a, b, c));
        System.out.printf("maxNum: %s \n", maxNum.calculate(3, 4, 5));

        Service middle = (int a, int b, int c) -> (a + b + c) / 3;
        System.out.printf("middle: %s \n", middle.calculate(3, 4, 5));

        Service sum = (int a, int b, int c) -> a + b + c;
        System.out.printf("sum: %s \n ", sum.calculate(3, 4, 5));

    }
}
