package getarraymean;
import java.util.Scanner;

public class GetArrayMean {
	public static int getArrayMean(int[] arr) {
		int sum = 0;
		for(int num = 0; num < arr.length; num++) {
			sum += arr[num];
		}
		return sum/arr.length;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter number of elements: ");
		int n = input.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			System.out.print("Enter number: " );
			arr[i] = input.nextInt();
		}
		int mean_value = getArrayMean(arr);
		
		System.out.print("Mean of array is: " + mean_value);
		input.close();
	}
}

