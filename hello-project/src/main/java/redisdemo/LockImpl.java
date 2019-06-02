package redisdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

/**
 * @author i324779
 */
public class LockImpl extends JedisBaseService implements ILock {

    private static final String LOCK = "lock:id:%s";
    private static final int TIMEOUT = 600000;
    private static final int EXPIRE = 3600;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void getLock(Jedis jedis, String id) {
        getLock(jedis, id, 0);
    }

    @Override
    public boolean getLock(Jedis jedis, String id, int timeout) {
        long lock;
        long start = System.currentTimeMillis();
        while (true) {
            long now = System.currentTimeMillis();
            //判断超时
            if (timeout > 0 && now > start + timeout) {
                return false;
            }
            long timestamp = now + TIMEOUT + 1;
            String key = getFormatKeyStr(LOCK, id);
            lock = jedis.setnx(key, String.valueOf(timestamp));
            if (lock == 1) {
                jedis.expire(key, EXPIRE);
                logger.debug("setnx");
                break;
            }
            //检查锁是否过期
            String lastLock = jedis.get(key);
            if (lastLock == null) {
                continue;
            }
            long lastLockTime = Long.parseLong(lastLock);
            if (lastLockTime < now) {
                //设置新的过期时间,检查是否被修改
                long oldLockTime = Long.parseLong(jedis.getSet(key, String.valueOf(timestamp)));
                if (oldLockTime < now) {
                    logger.debug("expire and set");
                    break;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                logger.error("An unexpected error occurred.", e);
            }
        }
        return true;
    }

    @Override
    public void releaseLock(Jedis jedis, String id) {
        String key = getFormatKeyStr(LOCK, id);
        String val = jedis.get(key);
        if (val == null) {
            return;
        }
        long lastLockTime = Long.parseLong(val);
        if (lastLockTime > System.currentTimeMillis() / 1000) {
            jedis.del(key);
        }
    }
}
