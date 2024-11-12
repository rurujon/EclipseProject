package com.day4;

public class Exam4GPT {

	public static void printGugu(int start, int end) {
        for (int i = 1; i <= 9; i++) {
            for (int j = start; j <= end; j++) {
                int result = i * j;
                System.out.printf("%d * %d = %d\t", j, i, result);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 2단부터 5단 출력
        System.out.println("2단부터 5단:");
        printGugu(2, 5);

        // 6단부터 9단 출력
        System.out.println("6단부터 9단:");
        printGugu(6, 9);
    }
}
