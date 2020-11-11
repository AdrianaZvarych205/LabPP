package com.butterfly.task;

import java.util.Scanner;

public class Main {

    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int left, right, n;
        System.out.println("Enter bounds and fibo length: ");
        left = sc.nextInt();
        right = sc.nextInt();
        n = sc.nextInt();

        LabPP14 task = new LabPP14();
        task.inputArray(left, right);
        task.display();
        task.displaySums();
        task.buildFib(n);
        task.getFiboPercentage();
    }
}
