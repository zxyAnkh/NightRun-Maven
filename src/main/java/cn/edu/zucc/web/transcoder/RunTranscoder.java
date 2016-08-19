package cn.edu.zucc.web.transcoder;

import cn.edu.zucc.core.feature.cache.redis.ObjectsTranscoder;
import cn.edu.zucc.web.model.Run;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 将夜跑数据转换为 byte[]
 * Created by zxy on 2016/7/8.
 * @author zxyAnkh
 * @since  2016-07-08
 */
public class RunTranscoder implements ObjectsTranscoder<Run> {
    @Override
    public byte[] serialize(List<Run> value) {
        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            for (Run run : value) {
                os.writeObject(run);
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

    @Override
    public List<Run> deserialize(byte[] in) {
        List<Run> list = new ArrayList<Run>();
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                while (true) {
                    Run run = (Run) is.readObject();
                    if (run == null) {
                        break;
                    } else {
                        list.add(run);
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
