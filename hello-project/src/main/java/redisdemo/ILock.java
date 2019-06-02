package redisdemo;

import redis.clients.jedis.Jedis;

/**
 * redis实现的分布式锁
 */
public interface ILock {

    /**
     * 获得锁
     *
     * @param jedis
     * @param id    键标识
     */
    void getLock(Jedis jedis, String id);

    /**
     * 是否获得锁
     *
     * @param jedis
     * @param id      键标识
     * @param timeout 超时时间
     * @return true 已取得锁; false 未取得锁
     */
    boolean getLock(Jedis jedis, String id, int timeout);

    /**
     * 释放锁
     *
     * @param jedis
     * @param id    键标识
     */
    void releaseLock(Jedis jedis, String id);
}
