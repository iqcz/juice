package algorithm;

/**
 * 鸡兔同笼问题
 * 使用穷举算法
 */
public class JiTu {

    private static int chicken;
    private static int rabbit;

    public static int qiongju(int head, int foot) {
        int retValue = 0;
        int i;
        int j;

        for (i = 0; i <= head; i++) {
            j = head - i;

            if (i * 2 + j * 4 == foot) {
                retValue = 1;
                chicken = i;
                rabbit = j;
            }
        }

        return retValue;
    }

    public static void main(String[] args) {
        qiongju(35, 94);
        System.out.println("Chicken numbers: " + chicken);
        System.out.println("Rabbit numbers: " + rabbit);
    }
}
