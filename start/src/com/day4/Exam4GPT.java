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
        // 2�ܺ��� 5�� ���
        System.out.println("2�ܺ��� 5��:");
        printGugu(2, 5);

        // 6�ܺ��� 9�� ���
        System.out.println("6�ܺ��� 9��:");
        printGugu(6, 9);
    }
}
