package algorithm.songjuan;

/**
 * 打印字符串中汉字的 Unicode 编码，非汉字则自动跳过。
 *
 * @author i324779
 */
public class DispUnicode {
    public static void main(String[] args) {
        DispUnicode dispUnicode = new DispUnicode();
        dispUnicode.queryUnicode("一枚码农");
    }


    private void queryUnicode(String achar) {
        System.out.println("字符串是：" + achar);

        for (int i = 0; i < achar.length(); i++) {
            // 判断是否是汉字，不是汉字直接跳过
            char ch = achar.charAt(i);

            if (ch < 19968 || ch > 40869) {
                continue;
            }

            System.out.println((int) ch + " ");
            // 或者下面的方式
            System.out.println(Integer.toHexString(ch));
        }
    }
}


