package cn.edu.zucc.core.feature.cache.redis;

import java.util.List;

/**
 * Created by zxy on 2016/7/8.
 * @author zxyAnkh
 * @since 2016-07-09
 */
public interface ObjectsTranscoder<T> {

    /**
     * 序列化
     *
     * @param value
     * @return
     */
    byte[] serialize(List<T> value);

    /**
     * 解序列化
     *
     * @param in
     * @return
     */
    List<T> deserialize(byte[] in);
}
