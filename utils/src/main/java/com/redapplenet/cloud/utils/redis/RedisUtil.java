package com.redapplenet.cloud.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Description redis 工具类
 * @Author liuqn
 * @Date 2019/2/26 16:07
 * @Version
 **/
@Component
public class RedisUtil<T> {



@Autowired
private RedisTemplate<String,T> redisTemplate;

// =============================common============================
    /**
     * @Author liuqn
     * @Description 设置有效期
     * @Date 16:23 2019/2/26
     * @Param [key, time：时间点]
     * @return boolean
     **/
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /** 过期时间
     * @Author liuqn
     * @Description //TODO
     * @Date 16:24 2019/2/26
     * @Param [key]
     * @return long
     **/
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * @Author liuqn
     * @Description key是否存在
     * @Date 16:25 2019/2/26
     * @Param [key]
     * @return boolean
     **/
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Author liuqn
     * @Description 删除key，可多个
     * @Date 16:26 2019/2/26
     * @Param [key]
     * @return void
     **/
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    // ============================Object=============================
    /**
     * @Author liuqn
     * @Description 获取对象
     * @Date 16:27 2019/2/26
     * @Param [key]
     * @return java.lang.Object
     **/
    public T get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * @Author liuqn
     * @Description 缓存对象
     * @Date 16:29 2019/2/26
     * @Param [key, value,time:间(秒) time要大于0 如果time小于等于0 将设置无限期]
     * @return boolean
     **/
    public boolean set(String key,  T value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                redisTemplate.opsForValue().set(key, value, 0, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

// ================================Map=================================
    /**
     * @Author liuqn
     * @Description 获取
     * @Date 16:56 2019/2/26
     * @Param [key, item]
     * @return java.lang.Object
     **/
    public T hget(String key, String item) {
        return (T)redisTemplate.opsForHash().get(key, item);
    }

    /**
     * @Author liuqn
     * @Description 获取Map
     * @Date 17:05 2019/2/26
     * @Param [key]
     * @return java.util.Map<java.lang.String,T>
     **/
    public Map<String, T> hmget(String key) {
        HashOperations<String, String, T> stringObjectObjectHashOperations = redisTemplate.opsForHash();
        return stringObjectObjectHashOperations.entries(key);
    }

    /**
     * @Author liuqn
     * @Description 缓存Map
     * @Date 17:06 2019/2/26
     * @Param [key, map, time]
     * @return boolean
     **/
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * @Author liuqn
     * @Description 向一张hash表中放入数据,如果不存在将创建
     * @Date 17:08 2019/2/26
     * @Param [key, item, value, time]
     * @return boolean
     **/
    public boolean hset(String key, String item, T value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Author liuqn
     * @Description 删除hash表中的值
     * @Date 17:08 2019/2/26
     * @Param [key, item]
     * @return void
     **/
    public void hdel(String key, T... item) {
        redisTemplate.opsForHash().delete(key, item);
    }
    
    /**
     * @Author liuqn
     * @Description 判断hash表中是否有该项的值
     * @Date 17:10 2019/2/26
     * @Param [key, item]
     * @return boolean
     **/
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }
// ============================set=====================================

    /**
     * @Author liuqn
     * @Description 根据key获取Set集合
     * @Date 16:16 2019/2/26
     * @Param [key]
     * @return java.util.Set<T>
     **/
    public Set<T> sGet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author liuqn
     * @Description 指定key的set中是否存在value的值
     * @Date 16:38 2019/2/26
     * @Param [key, time, value]
     * @return boolean
     **/
    public boolean sHasKey(String key,long time, T... value) {
        try {
            Boolean count = redisTemplate.opsForSet().isMember(key, value);
            if (time > 0){
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * @Author liuqn
     * @Description 保存Set集合
     * @Date 16:44 2019/2/26
     * @Param [key, time]
     * @return long
     **/
    public long sSetAndTime(String key, long time, T... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0)
            expire(key, time);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @Author liuqn
     * @Description 移除值为value的元素
     * @Date 16:40 2019/2/26
     * @Param [key, values]
     * @return long
     **/
    public long removeSet(String key, T... values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // ===============================list=================================
    /**
     * @Author liuqn
     * @Description 获取list缓存的内容
     * @Date 16:18 2019/2/26
     * @Param [key, start, end]
     * @return java.util.List<T>
     **/
    public List<T> lGet(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @Author liuqn
     * @Description 将一个对象保存到List
     * @Date 16:47 2019/2/26
     * @Param [key, value]
     * @return boolean
     **/
    public boolean lSet(String key,long time, T value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0){
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * @Author liuqn
     * @Description 将整个list保存到List
     * @Date 16:49 2019/2/26
     * @Param [key, value]
     * @return boolean
     **/
    public boolean lSet(String key, long time,List<T> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0){
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Author liuqn
     * @Description 按索引修改List中的值
     * @Date 16:51 2019/2/26
     * @Param [key, index, value]
     * @return boolean
     **/
    public boolean lUpdateIndex(String key, long index, T value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Author liuqn
     * @Description 移除N个值为value
     * @Date 16:53 2019/2/26
     * @Param [key, count, value]
     * @return long
     **/
    public long lRemove(String key, long count, Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
