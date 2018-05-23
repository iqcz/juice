package exam;

public class FindAndInsert {

    public static void main(String[] args) {
	int[] numbers = { 1, 4, 6, 7, 9, 12, 90, 90, 322 };
	int target = 13;
	
	findAndInsert(numbers, target);
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
		    newNumbers[i+ 1] = numbers[i];
		} else {
		    newNumbers[i +1] = target;

		    for (int j = 0; j <= i; j++) {
			newNumbers[j] = numbers[j];
		    }
		    break;
		}
	    }

	    for (int k = 0; k < newNumbers.length; k++) {
		System.out.print(newNumbers[k] + " ");
	    }

	}

	return index;
    }

}
