package exam;

/**
 * 选择排序 基本原理： 对于给定的一组记录，经过第一轮比较后得到最小的记录，然后将记录与第一个记录的位置进行交换；
 * 接着对不包括第一个记录以外的其他记录进行第二轮比较，得到最小的记录并与第二个记录进行位置交换； 重复该过程，知道进行比较的记录只有一个时为止。
 * 
 * @author TurtusLi
 *
 */
public class Example014 {

    public static void selectSort(int[] a) {
        int i;
        int j;
        int tmp = 0;
        int flag = 0;
        int n = a.length;

        for (i = 0; i < n; i++) {
            tmp = a[i];
            flag = i;

            for (j = i + 1; j < n; j++) {
                if (a[j] < tmp) {
                    tmp = a[j];
                    flag = j;
                }
            }

            if (flag != i) {
                a[flag] = a[i];
                a[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int i = 0;
        int[] a = { 1, 8, 5, 2, 4, 9, 7 };
        selectSort(a);

        for (i = 0; i < a.length; i++) {
            System.out.printf("%d, ", a[i]);
        }
    }
}
