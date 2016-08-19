package cn.edu.zucc.core;

import cn.edu.zucc.core.feature.test.TestSupport;
import cn.edu.zucc.core.util.PasswordHash;
import org.junit.Test;

/**
 * Created by zxy on 2016/7/7.
 */
public class PasswordHashTest extends TestSupport {
    @Test
    public void encryption() throws Exception {
        String password = "123456";
        System.out.println(PasswordHash.createHash(password));
        System.out.println(PasswordHash.createHash(password));
        System.out.println(PasswordHash.createHash(password));
        System.out.println(PasswordHash.createHash(password));
        System.out.println(PasswordHash.createHash(password));

    }

    @Test
    public void decryption() throws Exception{
        for(int i = 1 ; i <= 10; i++) {
            String str = PasswordHash.createHash("123456");
            System.out.println(str + "    " + PasswordHash.validatePassword("123456", str));
            System.out.println(PasswordHash.validatePassword("123456","1000:77d2ba618bca5717edaab476b137b250:d0b78c2dfbd68883a57de2a3fcc29272"));
        }
    }
}
