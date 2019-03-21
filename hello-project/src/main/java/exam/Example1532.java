package exam;

import java.util.ArrayList;

/**
 * 定义有数组int[] a = {1, 2, 3...},数组元素都为整数
 * 且a[i+1] > a[i]。
 * 请快速输出a[i]=i的数字。
 * @author TurtusLi
 *
 */
public class Example1532 {

    public static ArrayList<Integer> find(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= arr.length - 1;) {
            if (arr[i] == i) { // 找到满足条件的数，添加到结果中，继续遍历下一个数
                result.add(i++);
            } else if (arr[i] > i) { // 当arr[i] > i时，则接下来的arr[i]-i-1个数肯定不满足arr[i] == i
                i = i + (arr[i] - i);
            } else { // 遍历下一个数
                i++;
            }
        }

        return result;
    } //end method find

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 3, 5, 7, 8, 9, 10, 11 };

        ArrayList<Integer> result = find(arr);
        if (result.size() == 0) {
            System.out.println("不存在满足条件的数。");
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.println("满足条件的数为：a[" + result.get(i) + "] == " + result.get(i));
            }
        }
    } // end method main

}
