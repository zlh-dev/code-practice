package cn.code.mybatisplus;

import cn.code.mybatisplus.service.ProvincesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private ProvincesService provincesService;

    @Test
    void contextLoads() throws JsonProcessingException {
        Page<Object> objects = PageHelper.startPage(1, 3).doSelectPage(() -> provincesService.list());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(objects);
        System.out.println(json);
    }

}
