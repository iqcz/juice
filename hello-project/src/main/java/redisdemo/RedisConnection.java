package redisdemo;

import redis.clients.jedis.Jedis;

/**
 * Using Jedis client to connect Redis server.
 * Created on 2018-09-01
 * @author Phideon
 */
public class RedisConnection {

    public static void main(String[] args) {
        // connect to local redis server.
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connected successfully.");

        // check server whether is running.
        System.out.println(jedis.ping());

    }
}
