package getarraymean;

import java.util.Scanner;

public class MultiplicationTable {
	
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the maximum number for the multiplication table: ");
        int max_num = input.nextInt();

        int[][] table = new int[max_num + 1][max_num + 1];

        for (int i = 1; i <= max_num; i++) {
            for (int j = 1; j <= max_num; j++) {
                table[i][j] = i * j;
            }
        }

        System.out.println("Multiplication Table:");
        for (int i = 1; i <= max_num; i++) {
            for (int j = 1; j <= max_num; j++) {
                System.out.printf("%4d", table[i][j]);
            }
            System.out.println();
        }
        input.close();
    }
}