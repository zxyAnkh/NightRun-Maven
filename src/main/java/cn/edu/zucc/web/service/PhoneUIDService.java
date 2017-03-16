package cn.edu.zucc.web.service;

/**
 * Created by zxy on 3/16/2017.
 */
public interface PhoneUIDService {

    boolean updatePhoneUID(String no, String uid);

    String getPhoneUID(String no);

}
