package algorithm.sorting;

class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] returnArr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int one = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (one + nums[j] == target) {
                    returnArr[0] = i;
                    returnArr[1] = j;
                }
            }
        }

        return returnArr;
    }

    public static void main(String[] args) {
        TwoSum so = new TwoSum();

        int[] nums = { 2, 7, 11, 15, 45, 16, 90 };

        int[] indexs = so.twoSum(nums, 27);

        for (int element : indexs) {
            System.out.println(element);
        }

    }
}