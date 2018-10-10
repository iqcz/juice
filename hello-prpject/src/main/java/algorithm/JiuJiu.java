package algorithm;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

/**
 * 使用一层循环打印九九乘法表
 * @author User
 *
 */
public class JiuJiu {

    public static void main(String[] args) {
        for (int i = 1, j = 1; j <= 9; i++) {
            System.out.print(i + " * " + j + " = " + i * j + "    ");
            if (i == j) {
                i = 0;
                j++;
                System.out.println();
            }
        }

        String ids = "";

        if (!Strings.isNullOrEmpty(ids)) {
            Iterable<String> values = Splitter.on(",").omitEmptyStrings().split(ids);
            List<Integer> idList = new ArrayList<>();
            values.forEach(element -> idList.add(Integer.parseInt(element)));

            System.out.println(idList);

            String joinIds = Joiner.on(",").skipNulls().join(idList.iterator());

            System.out.println(joinIds);
        }
    }
}
