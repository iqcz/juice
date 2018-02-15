package book.javaspecialtroops.annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * use annotation and reflection to map db column to DO field.
 * @author i324779
 *
 */
public class TestMain {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
	@SuppressWarnings({ "serial" })
	List<HashMap<String, String>> list = Arrays.asList(new HashMap<String, String>() {
	    {
		put("name", "li");
		put("title", "shuai");
	    }
	}, new HashMap<String, String>() {
	    {
		put("name", "wang");
		put("title", "mei");
	    }
	});
	List<UserDO> users = new ArrayList<UserDO>(list.size());
	for (HashMap<String, String> row : list) {
	    users.add(ConvertionService.convertMapToBean(row, UserDO.class));
	}
	System.out.println();

	// 这里可以将users列表输出
	users.forEach(user -> {
	    System.out.println(user.getUserName() + ", " + user.getUserTitle());
	});
    }
}
