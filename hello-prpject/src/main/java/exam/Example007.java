package exam;

/**
 * 插入排序
 * 实现过程：
 * 对于给定的一组记录，初始时假设第一个记录自成一个有序序列，其余的记录为无序序列。
 * 接着从第二个记录开始，按照记录的大小依次将当前处理的记录插入到其之前的有序序列中，
 * 直到最后一个记录插入到有序序列中为止。
 * 
 * @author i324779
 *
 */
public class Example007 {

	public static void insertSort(int[] a) {
		if (null == a || a.length == 0) {
			return;
		}

		for (int i = 1; i < a.length; i++) { // 注意，数组下表从1开始
			// 把 a[i] 插入到a[0 ~ i -1 ] 的有序子列表中
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
