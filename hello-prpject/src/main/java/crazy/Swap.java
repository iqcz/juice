package crazy;

/**
 * 不使用 for，while，if，else，switch，case 等关键字以及条件判断语句来实现1 到 n 的累加。 
 * 可以使用三元运算符。
 * 
 * @author Yanxue Li
 *
 */
public class Swap {

	static int sum;

	public static int iSum(int n) {
		sum += n; // 进行累加求和
		sum = n == 0 ? sum : iSum(--n); // 进行递归调用

		return sum; // 返回计算结果
	}

	public static void main(String[] args) {
		int n = 100; // 定义并初始化变量
		int tSum = Swap.iSum(n); // 计算联系整数的和

		System.out.printf("1 至 %d 连续整数的和如下：\n", n);
		System.out.printf("1 + 2 + ... + %d = %d.", n, tSum);

	}

}
