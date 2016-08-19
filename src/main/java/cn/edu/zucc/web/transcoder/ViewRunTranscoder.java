package cn.edu.zucc.web.transcoder;

import cn.edu.zucc.core.feature.cache.redis.ObjectsTranscoder;
import cn.edu.zucc.web.model.ViewRun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 将具体夜跑数据转换为 byte[]
 * Created by zxy on 2016/7/8.
 * @author zxyAnkh
 * @since  2016-07-08
 */
public class ViewRunTranscoder implements ObjectsTranscoder<ViewRun>{
    @Override
    public byte[] serialize(List<ViewRun> value) {
        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            for (ViewRun viewRun : value) {
                os.writeObject(viewRun);
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
    public List<ViewRun> deserialize(byte[] in) {
        List<ViewRun> list = new ArrayList<ViewRun>();
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                while (true) {
                    ViewRun viewRun = (ViewRun) is.readObject();
                    if (viewRun == null) {
                        break;
                    } else {
                        list.add(viewRun);
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
