package cn.code.mybatisplus;

import cn.code.mybatisplus.service.ProvincesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisplusApplicationTests {
    @Autowired
    private StringEncryptor encryptor;
    @Autowired
    private ProvincesService provincesService;

    @Test
    void contextLoads() throws JsonProcessingException {
        Page<Object> objects = PageHelper.startPage(1, 3).doSelectPage(() -> provincesService.list());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(objects);
        System.out.println(json);
    }

    /**
     * 加密示例
     */
    @Test
    void encrypt() {
        String url = encryptor.encrypt("jdbc:mysql://localhost:3306/mysql?autoReconnect=true&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8");
        String name = encryptor.encrypt("root");
        String password = encryptor.encrypt("123456");
        System.out.println("database url: " + url);
        System.out.println("database name: " + name);
        System.out.println("database password: " + password);
        Assert.assertTrue(url.length() > 0);
        Assert.assertTrue(name.length() > 0);
        Assert.assertTrue(password.length() > 0);
    }
}
