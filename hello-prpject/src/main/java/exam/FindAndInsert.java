package exam;

import java.util.Scanner;

public class FindAndInsert {

	public static void main(String[] args) {
		int[] numbers = { 1, 4, 6, 7, 9, 12, 90, 90, 322 };
		int target = 1;

		System.out.println(findAndInsert(numbers, target));

		int[] arr = { 100, 70, 50, 30, 30, 10, 0 };
		int[] bb = new int[arr.length + 1];
		System.out.print("请输入你要插入的数字：");
		Scanner input = new Scanner(System.in

		);
		int c = input.nextInt();
		for (int i = 0; i < arr.length; i++) {
			if (c >= arr[i]) {
				bb[i] = c;
				for (i = i + 1; i < bb.length; i++) {
					bb[i] = arr[i - 1];
				}
			} else {
				bb[i] = arr[i];
			}
		}
		System.out.print("插入之后的数组为：");
		for (int i = 0; i < bb.length; i++) {
			System.out.print(bb[i] + " ");
		}

	}

	public static int findAndInsert(int[] numbers, int target) {
		int index = -1;
		for (int i = 0; i < numbers.length; i++) {
			if (target == numbers[i]) {
				index = i;
			}
		}

		if (index == -1) {
			int[] newNumbers = new int[numbers.length + 1];
			for (int i = numbers.length - 1; i >= 0; i--) {
				if (numbers[i] > target) {
					newNumbers[i + 1] = numbers[i];
				} else {
					newNumbers[i + 1] = target;
					index = i + 1;

					for (int j = 0; j <= i; j++) {
						newNumbers[j] = numbers[j];
					}
					break;
				}
			}

			for (int k = 0; k < newNumbers.length; k++) {
				System.out.print(newNumbers[k] + " ");
			}
			System.out.println();

		}

		return index;
	}

}
