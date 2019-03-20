package exam;

import java.util.ArrayList;
import java.util.List;

public class Example004 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("asa");
        names.add("zhiling");
        names.add("reba");

        // 使用remove方法
        names.removeIf(name -> name.equals("asa"));

        /* 使用removeIf方法替代下面的代码
        while (iter.hasNext()) {
            String name = iter.next();
        
            if (name.equals("asa")) {
                iter.remove(); // 使用remove方法
            }
        }
        */
        System.out.println(names);

    }

}
