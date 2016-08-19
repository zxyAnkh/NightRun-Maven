package cn.edu.zucc.web.transcoder;

import cn.edu.zucc.core.feature.cache.redis.ObjectsTranscoder;
import cn.edu.zucc.web.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 将用户数据转换为 byte[]
 * Created by zxy on 2016/7/8.
 * @author zxyAnkh
 * @since  2016-07-08
 */
public class UserTranscoder implements ObjectsTranscoder<User>{
    /**
     * 序列化
     *
     * @param value
     * @return
     */
    public byte[] serialize(List<User> value) {
        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            for (User user : value) {
                os.writeObject(user);
            }
            os.writeObject(null);
            os.close();
            bos.close();
            rv = bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Non-serializable object", e);
        } finally {
            try {
                os.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rv;
    }

    /**
     * 解序列化
     *
     * @param in
     * @return
     */
    public List<User> deserialize(byte[] in) {
        List<User> list = new ArrayList<User>();
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                while (true) {
                    User user = (User) is.readObject();
                    if (user == null) {
                        break;
                    } else {
                        list.add(user);
                    }
                }
                is.close();
                bis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
