package cn.edu.zucc.web.transcoder;

import cn.edu.zucc.core.feature.cache.redis.ObjectsTranscoder;
import cn.edu.zucc.web.model.ViewTotal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 将夜跑汇总记录转换为 byte[]
 * Created by zxy on 2016/7/8.
 * @author zxyAnkh
 * @since  2016-07-08
 */
public class ViewTotalTranscoder implements ObjectsTranscoder<ViewTotal> {
    @Override
    public byte[] serialize(List<ViewTotal> value) {
        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            for (ViewTotal viewTotal : value) {
                os.writeObject(viewTotal);
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
    public List<ViewTotal> deserialize(byte[] in) {
        List<ViewTotal> list = new ArrayList<ViewTotal>();
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                while (true) {
                    ViewTotal viewTotal = (ViewTotal) is.readObject();
                    if (viewTotal == null) {
                        break;
                    } else {
                        list.add(viewTotal);
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
