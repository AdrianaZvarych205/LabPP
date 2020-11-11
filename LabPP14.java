package com.butterfly.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LabPP14 {
    private List<Integer> range;
    private final List<Integer> odd = new ArrayList<Integer>();
    private final List<Integer> even = new ArrayList<Integer>();
    private final List<Integer> fibonacci = new ArrayList<Integer>();

    public void inputArray(int left, int right) {
        range = IntStream.rangeClosed(left, right)
                .boxed().collect(Collectors.toList());
        loadOddEven();
    }

    private void loadOddEven() {
        for (int i = range.get(0) % 2 == 0 ? 1 : 0; i < range.size(); i += 2) {
            odd.add(range.get(i));
        }

        for (int i = (range.get(range.size() - 1) % 2 == 0 ? range.size() - 1 : range.size() - 2); i >= 0; i -= 2) {
            even.add(range.get(i));
        }
    }

    public void display() {
        for (Integer el : odd) {
            System.out.print(el + " ");
        }
        System.out.println();

        for (Integer el : even) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public void displaySums() {
        int oddSum = odd.stream()
                .reduce(0, Integer::sum);

        int evenSum = even.stream()
                .reduce(0, Integer::sum);

        System.out.println("Sum of odd: " + oddSum);
        System.out.println("Sum of even: " + evenSum);
    }

    public void buildFib(int n) {
        fibonacci.add(Collections.max(odd));
        fibonacci.add(Collections.max(even));

        for (int i = 0; i < n - 2; i++) {
            fibonacci.add(fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2));
        }

        for (Integer el : fibonacci) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public void getFiboPercentage() {
        int nOdd = 0, nEven = 0;
        for (Integer el : fibonacci) {
            if (el % 2 == 0) {
                nEven++;
            } else {
                nOdd++;
            }
        }

        System.out.println("Percentage of odd: " + ((nOdd * 100) / (nOdd + nEven)) + "%");
        System.out.println("Percentage of even: " + ((nEven * 100) / (nOdd + nEven)) + "%");
    }

}
