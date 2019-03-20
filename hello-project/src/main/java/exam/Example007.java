package exam;

/**
 * 插入排序
 * 对于给定的一组记录，初始时假设第一个记录自成一个有序序列，其余的记录为无序序列。
 * 接着从第二个记录开始，按照记录的大小依次将当前处理的记录插入到之前的有序序列中，
 * 直到最后一个记录出入到有序序列中为止。
 * 以数组{38， 65， 97， 76， 13， 27，49}为例，直接插入排序具体步骤如下所示：
 * 第一步插入38以后，序列为[38] 65 97 76 13 27 49
 * 第二步插入65以后，序列为[38 65] 97 67 13 27 49
 * 第三步插入97以后，序列为[38 65 97] 76 13 27 49
 * 第四步插入76以后，序列为[38 65 76 97] 13 27 49
 * 第五步插入13以后，序列为[13 38 65 76 97] 27 49
 * 第六步插入27以后，序列为[13 27 38 65 76 97] 49
 * 第七步插入49以后，序列为[13 27 38 49 65 76 97]
 * 
 * @author i324779
 *
 */
public class Example007 {

    public static void insertSort(int[] a) {
        // 第一步，最好做判断处理
        if (null == a || a.length == 0) {
            return;
        }

        for (int i = 1; i < a.length; i++) { // 注意，数组下表从1开始
            // 把 a[i] 插入到a[0 ~ i - 1] 的有序子列表中
            int tmp = a[i];
            int j = i;

            if (a[j - 1] > tmp) {
                while (j >= 1 && a[j - 1] > tmp) {
                    a[j] = a[j - 1];
                    j--;
                }
            }
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = { 7, 3, 19, 40, 4, 7, 1 };

        insertSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

}
