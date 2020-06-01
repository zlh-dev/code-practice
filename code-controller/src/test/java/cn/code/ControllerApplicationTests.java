package cn.code;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ControllerApplicationTests {

    @Autowired
    private StringEncryptor encryptor;

    @Test
    void contextLoads() {

    }

    /**
     * 加密示例
     */
    @Test
    void encrypt() {
        String url = encryptor.encrypt("jdbc:mysql://xxx:3306/xxx?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF8");
        System.out.println(url);
    }
}
