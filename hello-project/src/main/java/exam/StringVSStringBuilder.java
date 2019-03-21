package exam;

/**
 * StringBuilder 不一定比 String 执行速度快
 * @author i324779
 *
 */
public class StringVSStringBuilder {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            StringBuilder sqlBuffer = new StringBuilder();
            sqlBuffer.append("select * from xxx where 1=1").append("and id = ? and name = ?")
                    .append("order by name desc");
            String sql = sqlBuffer.toString();
        }

        System.out.println(System.currentTimeMillis() - start);

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            String sql = "select * from xxx where 1=1" + "and id = ? and name = ?"
                    + "order by name desc";
        }
        System.out.println(System.currentTimeMillis() - start1);

        System.out.println(Integer.parseInt("10", 16));

    }

}
