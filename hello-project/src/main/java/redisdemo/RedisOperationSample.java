package redisdemo;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * @author LiYanxue
 * Created on 2018-09-01
 */
public class RedisOperationSample {

    public static void main(String[] args) {
        // connect to local redis server.
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connected successfully.");

        //set string type
        jedis.set("name", "Yaya");
        // get the name.
        System.out.println("name: " + jedis.get("name"));

        // set list type
        jedis.lpush("it", "English");
        jedis.lpush("it", "Java");
        jedis.lpush("it", "Reading");

        List<String> list = jedis.lrange("it", 0, 2);
        for (String element : list) {
            System.out.println("List element: " + element);
        }

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
